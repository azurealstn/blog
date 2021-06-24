package com.azurealstn.blog.service;

import com.azurealstn.blog.domain.user.User;
import com.azurealstn.blog.domain.user.UserRepository;
import com.azurealstn.blog.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 회원가입
     */
    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        String hashPassword = bCryptPasswordEncoder.encode(requestDto.getPassword());
        requestDto.hashing(hashPassword);
        return userRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * 전통적인 로그인 (시큐리티 적용X)
     */
/*    @Transactional(readOnly = true)
    public Long login(UserSaveRequestDto requestDto) {
        return userRepository.findByUsernameAndPassword(requestDto.getUsername(), requestDto.getPassword()).getId();
    }*/

}
