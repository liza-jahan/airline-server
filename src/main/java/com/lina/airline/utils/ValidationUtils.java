package com.lina.airline.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationUtils {
    public static final String NAME_VALIDATION = "^[A-Za-z\\s'-]+$\n";
    public static final String EMAIL_VALIDATION ="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    public static final String PASSWORD_VALIDATION ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}$";
    public static final   String PHONE_VALIDATION = "^\\+[1-9]\\d{1,14}$";
    public static final String PASSPORT_VALIDATION = "^[a-zA-Z0-9]{6,9}$";
}
