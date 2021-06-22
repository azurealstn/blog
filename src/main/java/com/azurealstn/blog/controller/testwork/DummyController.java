package com.azurealstn.blog.controller.testwork;

import com.azurealstn.blog.domain.user.Role;
import com.azurealstn.blog.domain.user.User;
import com.azurealstn.blog.domain.user.UserRepository;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(@RequestBody User user) {
        //user.setRole(Role.GUEST);
        return user.getUsername() + "님의 회원가입이 완료되었습니다. 비밀번호: " + user.getPassword() + ", 이메일: " + user.getEmail();
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저는 없습니다. id: " + id));
        return user;
    }

    @GetMapping("/dummy/user/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();
        return users;
    }

    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        //setter로 값을 변경해 update하는 로직
        //@Transactional을 쓰면 변경을 감지하여 커밋을 하는데 이렇게 변경을 감지하는 것을 더티 체킹이라고 한다.
        return user;
    }

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.getMessage();
        }

        return "삭제되었습니다. id: " + id;
    }
}
