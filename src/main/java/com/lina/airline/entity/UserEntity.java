package com.lina.airline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.Set;

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
