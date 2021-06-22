package com.azurealstn.blog.domain.reply;

import com.azurealstn.blog.domain.BaseTimeEntity;
import com.azurealstn.blog.domain.board.Board;
import com.azurealstn.blog.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Reply 테이블
 */
@Getter
@NoArgsConstructor
@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne //Reply : Board
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne //Reply : User
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public Reply(String content, Board board, User user) {
        this.content = content;
        this.board = board;
        this.user = user;
    }
}
