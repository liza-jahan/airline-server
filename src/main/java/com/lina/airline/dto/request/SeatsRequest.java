package com.lina.airline.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatsRequest {

    @NotBlank(message = "seat number is required")
    private String seatNumber;

    @NotBlank(message = "seat class is required")
    private String seatClass; // Economy, Business

    private boolean isAvailable;

    private int rowNumber;

    private char columnNumber;
}
