package com.lina.airline.aircraft;

import com.lina.airline.airlinesCompany.AirCompanyEntity;
import com.lina.airline.airlinesCompany.AirCompanyRepository;
import com.lina.airline.dto.request.AirCraftRequest;
import com.lina.airline.entity.UserEntity;
import com.lina.airline.exception.IdentifierExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.lina.airline.utils.ErrorDetails.ALREADY_EXISTS;

@Service
@AllArgsConstructor
public class AirCraftServiceImp implements AirCraftService {
    private final AirCraftRepository airCraftRepository;
    private final  AirCompanyRepository airCompanyRepository;

    @Override
    public UUID saveAirCraft(AirCraftRequest airCraftRequest, UUID registrationCode) {
        AirCompanyEntity airCompanyEntity= airCompanyRepository.findById(registrationCode).orElseThrow(() -> new RuntimeException("Not found by id"));

        if (isRegistrationNumberExists(airCraftRequest.getRegistrationNumber())) {
            throw new IdentifierExistException(ALREADY_EXISTS);
        }

        AircraftEntity aircraftEntity = new AircraftEntity();
        aircraftEntity.setCapacity(airCraftRequest.getCapacity());
        aircraftEntity.setModel(airCraftRequest.getModel());
        aircraftEntity.setAirline(airCompanyEntity);

        airCraftRepository.save(aircraftEntity);
        return aircraftEntity.getId() ;
    }

    private boolean isRegistrationNumberExists(String registrationNumber) {
        return airCraftRepository.existsByRegistrationNumber(registrationNumber);
    }


}
