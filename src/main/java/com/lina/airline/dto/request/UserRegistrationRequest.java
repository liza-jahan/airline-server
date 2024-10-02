package com.lina.airline.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.lina.airline.utils.ValidationUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegistrationRequest {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = NAME_VALIDATION)
    private String name;
    @NotBlank(message = "Email is required")
    @Pattern(regexp = EMAIL_VALIDATION)
    private String email;
    @NotBlank(message = "Password is required")
    @Pattern(regexp = PASSWORD_VALIDATION, message = "Password should contains Latter special character")
    private String password;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = PHONE_VALIDATION)
    private  String phoneNumber;
}
