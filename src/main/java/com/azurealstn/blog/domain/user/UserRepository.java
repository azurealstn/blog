package com.azurealstn.blog.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * DAO (Data Access Object)
 * 자동으로 빈이 등록된다. (@Repository 생략)
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * JPA Naming 전략 (로그인, 시큐리티 적용X)
     * select * from user where username = ? and where password = ?
     *
     * @Query를 이용해도 됨.
     */
    //User findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
