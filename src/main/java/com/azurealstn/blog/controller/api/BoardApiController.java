package com.azurealstn.blog.controller.api;

import com.azurealstn.blog.config.auth.PrincipalDetail;
import com.azurealstn.blog.dto.BoardSaveRequestDto;
import com.azurealstn.blog.dto.BoardUpdateRequestDto;
import com.azurealstn.blog.dto.ResponseDto;
import com.azurealstn.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * 글(Board) 관련 API
 */
@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    /**
     * 글쓰기 (기본적으로 title, content의 값만 거져오기 때문에 작성자를 가져오기 위해 User의 username도 같이 가져온다.)
     */
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.save(requestDto, principalDetail.getUser());
    }

    /**
     * 글 삭제하기
     */
    @DeleteMapping("/api/v1/board/{id}")
    public Long deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
        return id;
    }

    /**
     * 글 수정하기
     */
    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }
}
