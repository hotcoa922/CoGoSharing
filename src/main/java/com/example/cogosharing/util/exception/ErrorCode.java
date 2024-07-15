package com.example.cogosharing.util.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    //에러코드 추가 예정
    TMP(HttpStatus.NOT_FOUND,"임시");

    private final HttpStatus httpStatus;
    private final String message;
}