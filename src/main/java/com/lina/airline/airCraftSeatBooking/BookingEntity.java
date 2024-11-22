package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.airflight.FlightEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String passengerName;
    private String passengerEmail;
    private LocalDateTime bookingDate;

    private  boolean isConfirmed ;// Status of the booking

    @ManyToOne
    @JoinColumn(name = "seatId", nullable = false)
    private SeatsEntity seat;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;
}
