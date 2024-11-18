package com.lina.airline.airlinesCompany;

import com.lina.airline.aircraft.AircraftEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aircompany")
public class AirCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    @Column(unique = true)
    private String registrationCode;

    private String name;

    private String country; // Default to US for US-based airlines

    private LocalDateTime registeredDate;

    @OneToMany(mappedBy = "airline")
    private List<AircraftEntity> aircraftEntities;

}
