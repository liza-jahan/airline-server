package com.lina.airline.service;

import com.lina.airline.dto.request.UpdateUserRegistrationRequest;
import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;



public interface  UserService {

    UUID saveUser(UserRegistrationRequest userRegistrationRequest);
    Optional<UserEntity> updateUser(UUID id, UpdateUserRegistrationRequest userRegistrationRequest);
}
