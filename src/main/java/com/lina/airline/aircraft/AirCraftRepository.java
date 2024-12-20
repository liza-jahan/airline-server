package com.lina.airline.aircraft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirCraftRepository extends JpaRepository<AircraftEntity, UUID> {
    boolean existsByRegistrationNumber(String registrationNumber);
    boolean existsByAircraftId(UUID aircraftId);
}
