package com.commerce.toy.global.dto;

import com.commerce.toy.global.error.ApplicationError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.commerce.toy.global.error.ApplicationException;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {
    private final String message;
    private final String code;

    public static ErrorResponse fromException(ApplicationException e) {
        return new ErrorResponse(e.getMessage(), e.getCode());
    }

    public static ErrorResponse defaultError() {
        ApplicationError e = ApplicationError.INTERNAL_SERVER_ERROR;
        return new ErrorResponse(e.getMessage(), e.getCode());
    }
}
