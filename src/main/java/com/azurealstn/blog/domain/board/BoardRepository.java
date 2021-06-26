package com.azurealstn.blog.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Board DAO
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
