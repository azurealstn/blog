package com.azurealstn.blog.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void 회원가입_테스트() throws Exception {
        //given
        String username = "minsu";
        String passowrd = "1234";
        String email = "azurealstn@naver.com";

        userRepository.save(User.builder()
                .username(username)
                .password(passowrd)
                .email(email)
                .picture("picture")
                .role(Role.GUEST)
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(passowrd);
        assertThat(user.getEmail()).isEqualTo(email);
    }
}
