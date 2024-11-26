package com.lina.airline.airflight;

import com.lina.airline.airCraftSeatBooking.SeatsEntity;
import com.lina.airline.aircraft.AircraftEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flight")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @OneToMany
    private List<SeatsEntity> seats;

    @ManyToOne
    @JoinColumn(name = "aircraftId", nullable = false)
    private AircraftEntity aircraftEntity;
}
