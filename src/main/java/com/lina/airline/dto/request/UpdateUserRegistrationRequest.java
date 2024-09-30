package com.lina.airline.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class UpdateUserRegistrationRequest {
    @NotBlank(message = "Name is required")
    @Pattern(regexp = NAME_VALIDATION)
    private String name;
    @NotBlank(message = "Email is required")
    @Pattern(regexp = EMAIL_VALIDATION)
    private String email;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = PHONE_VALIDATION)
    private  String phoneNumber;
    private String gender;
    @Pattern(regexp = PASSPORT_VALIDATION)
    private String passportNumber;
    @Pattern(regexp = PHONE_VALIDATION)  //see this .....not same phone number
    private String emergencyPhoneNumber;
    private String presentAddress;
    private String permanentAddress;
    private String maritalStatus;
    private Date dateOfBirth;
    private String passportCountry;
    private Date passportExpiryDate;
    private int nationalId;
    private String nationality;
    private String religion;
    private String languagePreference;
}
