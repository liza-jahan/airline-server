package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.dto.request.BookingRequest;

public interface BookingService {
    int bookedSeat( boolean isAvailable ,int seatId, BookingRequest bookingRequest);
}
