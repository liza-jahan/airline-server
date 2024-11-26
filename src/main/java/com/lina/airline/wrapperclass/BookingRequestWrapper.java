package com.lina.airline.wrapperclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lina.airline.dto.request.BookingRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestWrapper {
    @JsonProperty("isAvailable")
    private  boolean isAvailable;
    private int seatId;
    private BookingRequest bookingRequest;
}
