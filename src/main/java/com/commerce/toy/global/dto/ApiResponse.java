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
    private int statusCode;
    private ErrorResponse error;

    public static <T> ApiResponse<T> success(T data, HttpStatus status) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .statusCode(status.value())
                .build();
    }

    public static ApiResponse<ErrorResponse> failure(ErrorResponse errorResponse) {
        return ApiResponse.<ErrorResponse>builder()
                .success(false)
                .error(errorResponse)
                .build();
    }
}
