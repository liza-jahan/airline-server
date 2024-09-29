package com.lina.airline.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

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
    private String phoneNumber;
    private String passportNumber;
    private  String emergencyPhoneNumber;



}
