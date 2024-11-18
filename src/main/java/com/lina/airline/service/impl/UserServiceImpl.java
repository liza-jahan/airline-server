package com.lina.airline.service.impl;

import com.lina.airline.dto.PaginationDto;
import com.lina.airline.dto.UserDTO;
import com.lina.airline.dto.request.UpdateUserRequest;
import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.entity.UserEntity;
import com.lina.airline.exception.IdentifierExistException;
import com.lina.airline.exception.NotFoundException;
import com.lina.airline.repository.UserRepository;
import com.lina.airline.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.lina.airline.utils.ErrorDetails.ALREADY_EXISTS;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UUID saveUser(UserRegistrationRequest userRegistrationRequest) {

        if (isUserExists(userRegistrationRequest.getEmail())) {
            throw new IdentifierExistException(ALREADY_EXISTS);
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
    public Optional<UserEntity> updateUserProfile(UUID id, UpdateUserRequest userRegistrationRequest) {

        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id is not found", "02-U02-002"));
        userEntity.setName(userRegistrationRequest.getName());
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

    @Override
    public PaginationDto<UserDTO> getAllUsers(int page, int size, String keyWord) {
        Page<UserEntity> userPage;
        if (keyWord != null && !keyWord.isEmpty()) {
            userPage = userRepository.findByNameContaining(keyWord, PageRequest.of(page, size));
        } else {
            userPage = userRepository.findAll(PageRequest.of(page, size));
        }

        List<UserDTO> users = userPage.stream()
                .map(user -> new UserDTO(
                        user.getName(),
                        user.getEmail(),
                        detectStatus(user.getLastLogIn()),
                        user.getLastLogIn()
                ))
                .collect(Collectors.toList());
        PaginationDto.PaginationInfo paginationInfo = new PaginationDto
                .PaginationInfo(page, size,
                userPage.getTotalPages(),
                userPage.getTotalElements()
        );
        return new PaginationDto<>(users, paginationInfo);
    }


    private boolean isUserExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private String detectStatus(Date lastLogin) {
        if (lastLogin == null) {
            return "Inactive";
        }

        long diffInMillis = new Date().getTime() - lastLogin.getTime();
        long daysDifference = diffInMillis / (1000 * 60 * 60 * 24);

        return daysDifference <= 10 ? "Active" : "Inactive";
    }


}
