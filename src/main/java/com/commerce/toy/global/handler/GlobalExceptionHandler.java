package com.commerce.toy.global.handler;

import com.commerce.toy.global.dto.ApiResponse;
import com.commerce.toy.global.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.commerce.toy.global.error.ApplicationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleApplicationException(ApplicationException e) {
        log.error("handleApplicationException : ", e);
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getCode());
        ApiResponse<ErrorResponse> response = ApiResponse.failure(errorResponse);
        return new ResponseEntity<>(response, e.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleException(Exception e) {
        log.error("Unexpected server error : ", e);
        ErrorResponse errorResponse = ErrorResponse.defaultError();
        ApiResponse<ErrorResponse> response = ApiResponse.failure(errorResponse);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}