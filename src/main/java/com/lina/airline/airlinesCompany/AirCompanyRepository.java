package com.lina.airline.airlinesCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompanyEntity, UUID> {

   boolean existsByRegistrationCode(String registrationCode);
  Optional<AirCompanyEntity> findByRegistrationCode(String registrationCode);

}
