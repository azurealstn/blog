package com.azurealstn.blog.config.auth;

import com.azurealstn.blog.domain.user.User;
import com.azurealstn.blog.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 스프링이 로그인을 가로챌 때 password부분은 알아서 처리해주고,
     * username만 DB에 있는지 확인해주는 메소드
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을  수 없습니다. ID: " + username));
        return new PrincipalDetail(principal);
    }
}
