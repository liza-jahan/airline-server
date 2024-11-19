package com.lina.airline.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorDetails {
    ALREADY_EXISTS("001_001_00001", "User already registered");
    private final String code;
    private final String message;
  //REGISTRATION_CODE_ALREADY_EXISTS("002_002_00001","Registration code already here");

}
