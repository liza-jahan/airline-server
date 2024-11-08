package com.lina.airline.dto.request;

import jakarta.persistence.*;
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

    private String registrationCode;

    private String name;


    private String country ;// Default to US for US-based airlines

    private LocalDateTime registeredDate;



}
