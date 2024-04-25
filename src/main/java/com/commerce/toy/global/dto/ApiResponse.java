package com.commerce.toy.global.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private HttpStatus status;

    public static <T> ApiResponse<T> success(T data, HttpStatus status) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .status(status)
                .build();
    }
}
