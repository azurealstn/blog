package com.azurealstn.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Member {

    private final Long id;
    private final String username;
    private final String password;
    private final String email;
}
