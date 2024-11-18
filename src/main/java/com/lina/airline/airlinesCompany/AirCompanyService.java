package com.lina.airline.airlinesCompany;

import com.lina.airline.dto.request.AirCompanyRequest;

import java.util.UUID;

public interface AirCompanyService {
    UUID saveAirCompany(AirCompanyRequest airCompanyRequest);
}
