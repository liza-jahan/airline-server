package com.lina.airline.aircraft;

import com.lina.airline.dto.APIResponse;
import com.lina.airline.dto.request.AirCompanyRequest;
import com.lina.airline.dto.request.AirCraftRequest;
import com.lina.airline.dto.response.CreationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;
@Slf4j
@RestController
@AllArgsConstructor
@Validated
public class AirCraftController {

    private final  AirCraftService airCraftService;
    @PostMapping("/add-aircraft/{registrationCode}")
    public ResponseEntity<APIResponse<CreationResponse>> registrationAirCraft(@RequestBody @Valid AirCraftRequest airCraftRequest, @PathVariable String registrationCode) {
        log.error("Air company with registration code {} not found", registrationCode);

        UUID CompanyId = airCraftService.saveAirCraft(airCraftRequest,registrationCode);
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
