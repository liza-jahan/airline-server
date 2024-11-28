package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.dto.request.SeatsRequest;

import java.util.List;
import java.util.UUID;

public interface SeatsService {
    void createSeatsForAircraft (SeatsRequest seatsRequest,String registrationNumber, int row, int column);
}
