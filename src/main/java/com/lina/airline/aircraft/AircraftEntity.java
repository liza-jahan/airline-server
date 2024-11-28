package com.lina.airline.aircraft;

import com.lina.airline.airCraftSeatBooking.SeatsEntity;
import com.lina.airline.airflight.FlightEntity;
import com.lina.airline.airlinesCompany.AirCompanyEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="aircraft")
@ToString(exclude = {"airline", "seatEntities"})
public class AircraftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID aircraftId;
    @Column(unique = true)
    private String registrationNumber;
    private String model;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private AirCompanyEntity airline;

    @OneToMany
    private List<SeatsEntity>seatEntities;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;
}
