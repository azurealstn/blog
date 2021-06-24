package com.azurealstn.blog.controller.api;

import com.azurealstn.blog.dto.UserSaveRequestDto;
import com.azurealstn.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 로그인과 회원가입에 대한 API
 */
@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    /**
     * 회원가입 API
     */
    @PostMapping("/auth/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    /**
     * 세션을 이용한 로그인 (시큐리티 적용 X)
     */
/*    @PostMapping("/api/v1/user/login")
    public Long login(@RequestBody UserSaveRequestDto requestDto, HttpSession session) {
        Long principal = userService.login(requestDto);

        if (principal != null) {
            session.setAttribute("principal", principal);
        }
        return principal;
    }*/
}
