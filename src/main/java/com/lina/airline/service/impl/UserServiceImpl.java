package com.lina.airline.service.impl;

import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.entity.UserEntity;
import com.lina.airline.exception.IdentifierExistException;
import com.lina.airline.repository.UserRepository;
import com.lina.airline.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static com.lina.airline.utils.ErrorDetails.USER_ALREADY_EXISTS;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UUID saveUser(UserRegistrationRequest userRegistrationRequest) {

        if (isUserExists(userRegistrationRequest.getEmail())){
            throw new IdentifierExistException(USER_ALREADY_EXISTS);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRegistrationRequest.getEmail());
        userEntity.setPassword(userRegistrationRequest.getPassword());
        userEntity.setName(userRegistrationRequest.getName());
        userEntity.setPhoneNumber(userRegistrationRequest.getPhoneNumber());
        userEntity.setPassportNumber(userRegistrationRequest.getPassportNumber());
        userEntity.setEmergencyPhoneNumber(userRegistrationRequest.getEmergencyPhoneNumber());

        userRepository.save(userEntity);
        return userEntity.getId();
    }


    private boolean isUserExists(String email){
        return userRepository.findByEmail(email).isPresent();
    }
}
