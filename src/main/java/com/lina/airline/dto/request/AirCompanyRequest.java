package com.lina.airline.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirCompanyRequest {

    private UUID id;
    @NotBlank(message = "Registration Code is required")
    private String registrationCode;
   @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Country is required")
    private String country ;

    private LocalDateTime registeredDate;



}
