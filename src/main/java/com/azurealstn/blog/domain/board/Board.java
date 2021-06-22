package com.azurealstn.blog.domain.board;

import com.azurealstn.blog.domain.BaseTimeEntity;
import com.azurealstn.blog.domain.reply.Reply;
import com.azurealstn.blog.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

/**
 * Board 테이블
 * 게시글에는 작성자와 댓글이 있으므로 User와 Reply를 조인한다.
 * Reply는 mappedBy를 써서 DB에 값을 저장하지 않고 필수로 값을 가져와야 하기 때문에 FetchType을 EAGER 전략으로 변경한다.
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

    @ManyToOne(fetch = FetchType.EAGER) //Board : User
    @JoinColumn(name = "userId")
    private User user; //FK 생성

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy: 연관관계의 주인이 아님(FK가 아님 -> DB에 컬럼 만들기 X)
    private List<Reply> reply; //여러개의 댓글을 List로 받기.

    @Builder
    public Board(String title, String content, int count, User user) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.user = user;
    }
}
