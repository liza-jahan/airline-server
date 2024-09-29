package com.lina.airline.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorDetails {
    USER_ALREADY_EXISTS("001_001_00001", "User already registered");

    private final String code;
    private final String message;
}
