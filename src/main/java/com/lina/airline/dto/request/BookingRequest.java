package com.lina.airline.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private String passengerName;
    private String passengerEmail;
    private  boolean isConfirmed ;

}
