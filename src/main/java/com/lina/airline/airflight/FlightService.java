package com.lina.airline.airflight;

import com.lina.airline.dto.request.FlightRequest;

import java.util.List;
import java.util.UUID;

public interface FlightService {
     int saveFlight(FlightRequest flightRequest, UUID aircraftId);
    List<FlightEntity> searchFlights(String origin,String destination);

}
