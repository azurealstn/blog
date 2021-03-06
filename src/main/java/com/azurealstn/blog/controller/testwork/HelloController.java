package com.azurealstn.blog.controller.testwork;

import com.azurealstn.blog.dto.HelloResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot에서 hello world 찍기
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>hello spring boot!</h1>";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
