package com.lina.airline.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

}
