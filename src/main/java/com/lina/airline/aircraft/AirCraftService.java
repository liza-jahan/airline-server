package com.lina.airline.aircraft;

import com.lina.airline.dto.request.AirCraftRequest;
import java.util.UUID;

public interface AirCraftService {

    UUID saveAirCraft(AirCraftRequest airCraftRequest, String registrationCode);

}
