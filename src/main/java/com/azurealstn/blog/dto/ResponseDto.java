package com.azurealstn.blog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * HTTP status, data { id 인덱스: 정상 }
 */
@Getter
@NoArgsConstructor
public class ResponseDto<T> {

    int status;
    T data;

    @Builder
    public ResponseDto(int status, T data) {
        this.status = status;
        this.data = data;
    }
}
