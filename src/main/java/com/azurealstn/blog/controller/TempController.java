package com.azurealstn.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring Boot + jsp 연동 테스트
 */
@Controller
public class TempController {

    @GetMapping("/temp/jsp")
    public String temp() {
        return "temp";
    }
}
