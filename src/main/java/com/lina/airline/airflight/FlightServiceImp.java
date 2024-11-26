package com.lina.airline.airflight;

import com.lina.airline.aircraft.AirCraftRepository;
import com.lina.airline.aircraft.AircraftEntity;
import com.lina.airline.dto.request.FlightRequest;
import com.lina.airline.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightServiceImp implements FlightService {
   private final   FlightRepository flightRepository;
   private final AirCraftRepository airCraftRepository;
    @Override
    public int saveFlight(FlightRequest flightRequest, UUID aircraftId) {
        AircraftEntity aircraftEntity= airCraftRepository.findById(aircraftId).orElseThrow(() -> new NotFoundException("Not Found Id",""));


        FlightEntity flightEntity=new FlightEntity();
        flightEntity.setFlightNumber(flightRequest.getFlightNumber());
        flightEntity.setOrigin(flightRequest.getOrigin());
        flightEntity.setDestination(flightRequest.getDestination());
        flightEntity.setArrivalTime(flightRequest.getArrivalTime());
        flightEntity.setDepartureTime(flightRequest.getDepartureTime());
        flightEntity.setAircraftEntity(aircraftEntity);

        flightRepository.save(flightEntity);
        return flightEntity.getId();
    }

    @Override
    public List<FlightEntity> searchFlights(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin,destination);
    }
}
