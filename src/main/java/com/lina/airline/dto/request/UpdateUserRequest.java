package com.lina.airline.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.lina.airline.utils.ValidationUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateUserRequest {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = NAME_VALIDATION)
    private String name;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = PHONE_VALIDATION)
    private String phoneNumber;
    private String gender;
    @Pattern(regexp = PASSPORT_VALIDATION)
    private String passportNumber;
    @Pattern(regexp = PHONE_VALIDATION)  //see this .....not same phone number
    private String emergencyPhoneNumber;
    @NotBlank(message = "Present address is required")
    @Size(min = 5, max = 100, message = "Present address must be between 5 and 100 characters")
    private String presentAddress;
    @NotBlank(message = "Permanent address is required")
    @Size(min = 5, max = 100, message = "Permanent address must be between 5 and 100 characters")
    private String permanentAddress;
    @NotBlank(message = "Marital status is required")
    private String maritalStatus;
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private Date dateOfBirth;
    @NotBlank(message = "Passport country is required")
    @Size(min = 2, max = 3, message = "Passport country must be a valid country code (2 or 3 characters)")
    private String passportCountry;
    @NotNull(message = "Passport expiry date is required")
    private Date passportExpiryDate;
    @Min(value = 1, message = "National ID must be a positive number")
    private int nationalId;
    @NotBlank(message = "Nationality is required")
    private String nationality;
    @Size(max = 50, message = "Religion must be less than or equal to 50 characters")
    private String religion;
    @NotBlank(message = "Language preference is required")
    private String languagePreference;
}
