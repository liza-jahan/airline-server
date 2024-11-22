package com.lina.airline.airCraftSeatBooking;

import com.lina.airline.aircraft.AircraftEntity;
import com.lina.airline.airflight.FlightEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seatdetails")
public class SeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "seat_number" ,unique = true)
    private String seatNumber;

    @Column(name = "seat_class")
    private String seatClass; // Economy, Business

    @Column(name = "is_available")
    private boolean isAvailable ;

    @Column(name = "seat_row_number")
    private char rowNumber;

    @Column(name = "seat_column_number")
    private int columnNumber;

    @ManyToOne
    @JoinColumn(name = "aircraftId", nullable = false)
    private AircraftEntity aircraftEntity;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;
}
