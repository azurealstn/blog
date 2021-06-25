package com.azurealstn.blog.service;

import com.azurealstn.blog.domain.board.Board;
import com.azurealstn.blog.domain.board.BoardRepository;
import com.azurealstn.blog.domain.user.User;
import com.azurealstn.blog.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long save(BoardSaveRequestDto requestDto, User user) {
        requestDto.setUser(user);
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * 페이징 전체조회
     */
    @Transactional(readOnly = true)
    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    /**
     * 글 상세조회
     */
    @Transactional(readOnly = true)
    public Board showDetail(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다. id: " + id));
    }

    /**
     * 글 삭제하기
     */
    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    /**
     * 글 수정하기
     */
    @Transactional
    public Long update(Long id, BoardSaveRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("글 수정하기 실패: 아이디를 찾을 수 없습니다. id: " + id));
        board.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
}
