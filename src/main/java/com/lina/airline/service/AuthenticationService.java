package com.lina.airline.service;

import com.lina.airline.dto.request.AuthenticationRequest;

import java.util.Optional;

public interface AuthenticationService {
   String loginUser(AuthenticationRequest authenticationRequest);
}
