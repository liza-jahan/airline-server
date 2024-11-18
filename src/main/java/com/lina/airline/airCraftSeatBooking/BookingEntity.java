package com.lina.airline.airCraftSeatBooking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private LocalDate flightDate;

    private  boolean isConfirmed = false; // Status of the booking

    @ManyToOne
    @JoinColumn(name = "seatId", nullable = false)
    private SeatsEntity seat;
}
