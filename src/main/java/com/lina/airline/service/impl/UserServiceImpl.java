package com.lina.airline.service.impl;

import com.lina.airline.dto.request.UpdateUserRegistrationRequest;
import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.entity.UserEntity;
import com.lina.airline.exception.IdentifierExistException;
import com.lina.airline.repository.UserRepository;
import com.lina.airline.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.lina.airline.utils.ErrorDetails.USER_ALREADY_EXISTS;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UUID saveUser(UserRegistrationRequest userRegistrationRequest) {

        if (isUserExists(userRegistrationRequest.getEmail())) {
            throw new IdentifierExistException(USER_ALREADY_EXISTS);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRegistrationRequest.getEmail());
        userEntity.setName(userRegistrationRequest.getName());
        userEntity.setPhoneNumber(userRegistrationRequest.getPhoneNumber());
        userEntity.setPassword(userRegistrationRequest.getPassword());

        userRepository.save(userEntity);
        return userEntity.getId();
    }

    @Override
    public Optional<UserEntity> updateUser(UUID id, UpdateUserRegistrationRequest userRegistrationRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Id  not found"));



        userEntity.setName(userRegistrationRequest.getName());
        userEntity.setEmail(userRegistrationRequest.getEmail());
        userEntity.setPhoneNumber(userRegistrationRequest.getPhoneNumber());
        userEntity.setPassportNumber(userRegistrationRequest.getPassportNumber());
        userEntity.setEmergencyPhoneNumber(userRegistrationRequest.getEmergencyPhoneNumber());
        userEntity.setGender(userRegistrationRequest.getGender());
        userEntity.setNationality(userRegistrationRequest.getNationality());
        userEntity.setDateOfBirth(userRegistrationRequest.getDateOfBirth());
        userEntity.setMaritalStatus(userRegistrationRequest.getMaritalStatus());
        userEntity.setLanguagePreference(userRegistrationRequest.getLanguagePreference());
        userEntity.setNationalId(userRegistrationRequest.getNationalId());
        userEntity.setPassportExpiryDate(userRegistrationRequest.getPassportExpiryDate());
        userEntity.setPermanentAddress(userRegistrationRequest.getPermanentAddress());
        userEntity.setPresentAddress(userRegistrationRequest.getPresentAddress());

        userRepository.save(userEntity);
        return Optional.of(userEntity);
    }


    private boolean isUserExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
