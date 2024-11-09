package com.lina.airline.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCraftRequest {
    private Long id;
    private String registrationNumber;
    private String model;
    private int capacity;
}
