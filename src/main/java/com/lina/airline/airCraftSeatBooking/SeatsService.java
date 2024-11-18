package com.lina.airline.airCraftSeatBooking;

import java.util.List;
import java.util.UUID;

public interface SeatsService {
    void createSeatsForAircraft (UUID aircraftId, int row, int column);
}
