package com.lina.airline.service;

import com.lina.airline.dto.request.UserRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface  UserService {

    UUID saveUser(UserRegistrationRequest userRegistrationRequest);
}
