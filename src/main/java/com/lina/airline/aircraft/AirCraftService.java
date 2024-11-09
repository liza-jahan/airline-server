package com.lina.airline.aircraft;

import com.lina.airline.dto.request.AirCraftRequest;

import java.util.Optional;
import java.util.UUID;

public interface AirCraftService {

    UUID saveAirCraft(AirCraftRequest airCraftRequest, UUID registrationCode);

}
