package com.lina.airline.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private Long id;
    private String passengerName;
    private String passengerEmail;
    private LocalDateTime bookingDate;
    private  boolean isConfirmed ; // Status of the booking

}
