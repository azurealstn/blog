package com.azurealstn.blog.domain.reply;

import com.azurealstn.blog.domain.BaseTimeEntity;
import com.azurealstn.blog.domain.board.Board;
import com.azurealstn.blog.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
