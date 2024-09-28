package com.lina.airline.entity;

import com.lina.airline.utils.ValidUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity {

    @NotBlank(message = "This field must be filled out.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    @Pattern(regexp = ValidUtils.nameRegex, message = "Name must contain only alphabetic characters, spaces, hyphens, or apostrophes.")
    private String name;
    @NotBlank(message = "This field must be filled ")
    @Email(message = "Must follow the standard email format")
    private String email;
    @NotBlank(message = "The Password field must be filled out.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @Pattern(regexp = ValidUtils.passwordRegex, message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.")
    private String password;

}
