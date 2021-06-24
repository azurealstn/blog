package com.azurealstn.blog.dto;

import com.azurealstn.blog.domain.board.Board;
import com.azurealstn.blog.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private int count;
    private User user;

    @Builder
    public BoardSaveRequestDto(String title, String content, int count, User user) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.user = user;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .count(count)
                .user(user)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
