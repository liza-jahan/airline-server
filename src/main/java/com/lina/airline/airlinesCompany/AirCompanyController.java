package com.lina.airline.airlinesCompany;

import com.lina.airline.dto.APIResponse;
import com.lina.airline.dto.request.AirCompanyRequest;
import com.lina.airline.dto.response.CreationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @PostMapping("/add-company")
    public ResponseEntity<APIResponse<CreationResponse>> registrationCompany(@RequestBody @Valid AirCompanyRequest airCompanyRequest) {
        UUID CompanyId = airCompanyService.saveAirCompany(airCompanyRequest);
        APIResponse<CreationResponse> responseDTO = APIResponse
                .<CreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponse(CompanyId))
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}