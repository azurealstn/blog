package com.azurealstn.blog.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private Long id;
    private String username;
    private String password;
    private String email;
}
