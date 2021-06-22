package com.azurealstn.blog.domain.board;

import com.azurealstn.blog.domain.BaseTimeEntity;
import com.azurealstn.blog.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * Board 테이블
 */
@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String title;

    @Lob //대용량 데이터
    private String content;

    @ColumnDefault("0")
    private int count;

    @ManyToOne //Board : User
    @JoinColumn(name = "userId")
    private User user; //FK 생성

    @Builder
    public Board(String title, String content, int count, User user) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.user = user;
    }
}
