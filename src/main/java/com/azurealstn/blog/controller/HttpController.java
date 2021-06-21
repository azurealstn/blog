package com.azurealstn.blog.controller;

import com.azurealstn.blog.domain.Member;
import org.springframework.web.bind.annotation.*;

/**
 * GET, POST, PUT, DELETE 요청 메소드를 테스트 하기 위한 클래스
 * 사용자가 요청 -> 응답(data) : @RestController
 * 사용자가 요청 -> 응답(HTML) : @Controller
 * 테스트는 Postman을 통해 실행할 것! (그 이유는 브라우저 요청은 get 요청밖에 안된다.)
 */
@RestController
public class HttpController {

    @GetMapping("/http/get")
    public String getTest(
            @RequestParam("id") Long id,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email) {
        return "get 요청 테스트: " + id + ", " + username + ", " + password + ", " + email;
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member member) {
        return "post 요청 테스트: " + member.getId() + ", " + member.getUsername() + ", " + member.getPassword() + ", " + member.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member member) {
        return "put 요청 테스트: " + member.getId() + ", " + member.getUsername() + ", " + member.getPassword() + ", " + member.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
