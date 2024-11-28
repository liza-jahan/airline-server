package com.lina.airline.airCraftSeatBooking;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lina.airline.aircraft.AircraftEntity;
import com.lina.airline.airflight.FlightEntity;
import com.lina.airline.enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "seatdetails", uniqueConstraints = @UniqueConstraint(columnNames = {"seatNumber", "aircraftId"})
)

public class SeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "seat_class")
    @Enumerated(EnumType.STRING)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private SeatType seatClass;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "seat_row_number")
    private char rowNumber;

    @Column(name = "seat_column_number")
    private int columnNumber;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "aircraftId", nullable = false)
    private AircraftEntity aircraftEntity;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;
}
