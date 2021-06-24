package com.azurealstn.blog.controller;

import com.azurealstn.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    /**
     * 메인 화면
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "index";
    }

    /**
     * 글쓰기 화면
     */
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
