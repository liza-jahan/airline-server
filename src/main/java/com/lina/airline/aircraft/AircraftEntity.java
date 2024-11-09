package com.lina.airline.aircraft;

import com.lina.airline.airlinesCompany.AirCompanyEntity;
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
@Table(name="aircraft")
public class AircraftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String registrationNumber;
    @Column(nullable = false)
    private String model;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private AirCompanyEntity airline;
}
