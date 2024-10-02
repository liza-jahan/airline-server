package com.lina.airline.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private final String errorCode;
    private final String message;

    public BaseException(String message, Throwable ex, String errorCode){
        super(message, ex);
        this.errorCode = errorCode;
        this.message = message;
    }

    public BaseException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
