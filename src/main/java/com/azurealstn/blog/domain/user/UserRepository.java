package com.azurealstn.blog.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO (Data Access Object)
 * 자동으로 빈이 등록된다. (@Repository 생략)
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
