package com.lina.airline.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirCraftRequest {
    @NotBlank(message = "Registration number is required")
    private String registrationNumber;
    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be greater than 0")
    private int capacity;

}
