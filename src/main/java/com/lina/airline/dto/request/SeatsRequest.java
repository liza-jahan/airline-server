package com.lina.airline.dto.request;

import com.lina.airline.enums.SeatType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatsRequest {



    @NotNull(message = "seat class is required")
    private SeatType seatClass;; // Economy, Business

}
