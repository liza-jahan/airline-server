package com.lina.airline.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity {

    private String name;
    private String email;
    private String password;


    private String gender;
    private String phoneNumber;
    private String passportNumber;
    private  String emergencyPhoneNumber;
    private String presentAddress;
    private String permanentAddress;
    private  String maritalStatus;
    private Date dateOfBirth;
    private String passportCountry;
    private Date passportExpiryDate;
    private int nationalId;
    private  String nationality;
    private  String religion;
    private String languagePreference;


}
