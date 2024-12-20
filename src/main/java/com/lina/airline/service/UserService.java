package com.lina.airline.service;

import com.lina.airline.dto.PaginationDto;
import com.lina.airline.dto.UserDTO;
import com.lina.airline.dto.request.UpdateUserRequest;
import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;



public interface  UserService {

    UUID saveUser(UserRegistrationRequest userRegistrationRequest);
    Optional<UserEntity> updateUserProfile(UUID id, UpdateUserRequest userRegistrationRequest);
    PaginationDto<UserDTO> getAllUsers(int page, int size,String keyWord);
}
