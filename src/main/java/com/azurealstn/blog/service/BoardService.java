package com.azurealstn.blog.service;

import com.azurealstn.blog.domain.board.Board;
import com.azurealstn.blog.domain.board.BoardRepository;
import com.azurealstn.blog.domain.user.User;
import com.azurealstn.blog.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto requestDto, User user) {
        requestDto.setUser(user);
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
