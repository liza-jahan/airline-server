package com.lina.airline.aircraft;

import com.lina.airline.airlinesCompany.AirCompanyEntity;
import com.lina.airline.airlinesCompany.AirCompanyRepository;
import com.lina.airline.dto.request.AirCraftRequest;
import com.lina.airline.exception.IdentifierExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.lina.airline.utils.ErrorDetails.ALREADY_EXISTS;
@Slf4j
@Service
@AllArgsConstructor
public class AirCraftServiceImp implements AirCraftService {
    private final AirCraftRepository airCraftRepository;
    private final  AirCompanyRepository airCompanyRepository;

    @Override
    public UUID saveAirCraft(AirCraftRequest airCraftRequest, String registrationCode) {

        Optional<AirCompanyEntity> airCompanyEntity= airCompanyRepository.findByRegistrationCode(registrationCode);
        if (airCompanyEntity.isEmpty()) {
            log.error("Air company with registration code {} not found", registrationCode);

            throw new IllegalArgumentException("Air company with registration code " + registrationCode + " not found");
        }


        if (isRegistrationNumberExists(airCraftRequest.getRegistrationNumber())) {
            throw new IdentifierExistException(ALREADY_EXISTS);
        }

        AircraftEntity aircraftEntity = new AircraftEntity();
        aircraftEntity.setCapacity(airCraftRequest.getCapacity());
        aircraftEntity.setModel(airCraftRequest.getModel());
        aircraftEntity.setRegistrationNumber(airCraftRequest.getRegistrationNumber());
        aircraftEntity.setAirline(airCompanyEntity.get());

        airCraftRepository.save(aircraftEntity);
        return aircraftEntity.getAircraftId() ;
    }

    private boolean isRegistrationNumberExists(String registrationNumber) {
        return airCraftRepository.existsByRegistrationNumber(registrationNumber);
    }


}
