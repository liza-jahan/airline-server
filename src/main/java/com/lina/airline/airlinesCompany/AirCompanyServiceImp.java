package com.lina.airline.airlinesCompany;

import com.lina.airline.dto.request.AirCompanyRequest;
import com.lina.airline.exception.IdentifierExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.lina.airline.utils.ErrorDetails.ALREADY_EXISTS;

@Service
@AllArgsConstructor
public class AirCompanyServiceImp implements AirCompanyService{
    private  final AirCompanyRepository airCompanyRepository;
    @Override
    public UUID saveAirCompany(AirCompanyRequest airCompanyRequest) {

        if(isRegistrationCodeExists(airCompanyRequest.getRegistrationCode())){
           throw new IdentifierExistException(ALREADY_EXISTS) ;
        }
        AirCompanyEntity airCompanyEntity=new AirCompanyEntity();
        airCompanyEntity.setName(airCompanyRequest.getName());
        airCompanyEntity.setCountry(airCompanyRequest.getCountry());
        airCompanyEntity.setRegistrationCode(airCompanyRequest.getRegistrationCode());
        airCompanyEntity.setRegisteredDate(LocalDateTime.now());
        airCompanyRepository.save(airCompanyEntity);

      return airCompanyEntity.getId();
    }

    private boolean isRegistrationCodeExists(String registrationCode) {
        return airCompanyRepository.existsByRegistrationCode(registrationCode);

    }
}
