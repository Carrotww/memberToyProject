package com.commerce.toy.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApplicationError {
    MEMBER_LOGIN_ID_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_001", "Member login id를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER_001", "서버 내부 에러가 발생하였습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
