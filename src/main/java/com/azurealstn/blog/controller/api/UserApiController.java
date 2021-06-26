package com.azurealstn.blog.controller.api;

import com.azurealstn.blog.config.auth.PrincipalDetail;
import com.azurealstn.blog.domain.user.User;
import com.azurealstn.blog.dto.ResponseDto;
import com.azurealstn.blog.dto.UserSaveRequestDto;
import com.azurealstn.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 로그인과 회원가입에 대한 API
 */
@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

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

    /**
     * 회원수정 API
     */
    @PutMapping("/api/v1/user")
    public ResponseDto<Integer> update(@RequestBody User user) {
        userService.update(user);
        //시큐리티 세션 부여
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }
}
