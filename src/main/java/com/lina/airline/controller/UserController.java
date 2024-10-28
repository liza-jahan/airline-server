package com.lina.airline.controller;


import com.lina.airline.dto.APIResponse;
import com.lina.airline.dto.PaginationDto;
import com.lina.airline.dto.UserDTO;
import com.lina.airline.dto.request.UpdateUserRequest;
import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.dto.response.CreationResponse;
import com.lina.airline.entity.UserEntity;
import com.lina.airline.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

   public final UserService userService;

    @PostMapping("/")
    public UUID registrationUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest){
        return userService.saveUser(userRegistrationRequest);
    }
  @PutMapping ("/updateUser/{id}")
    public ResponseEntity<APIResponse<CreationResponse>> updateUserProfile(@RequestBody @Valid UpdateUserRequest updateUserRegistrationRequest, @PathVariable UUID id){
    Optional<UserEntity> userEntity=userService.updateUserProfile(id,updateUserRegistrationRequest);
      APIResponse<CreationResponse> responseDTO = APIResponse
              .<CreationResponse>builder()
              .dateTime(new Date().toString())
              .status(HttpStatus.OK.getReasonPhrase())
              .code(HttpStatus.OK)
              .results(new CreationResponse(userEntity.get().getId()))
              .build();

      return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PaginationDto<UserDTO>> getAllUsers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        PaginationDto<UserDTO> response = userService.getAllUsers(page - 1, size);
        return ResponseEntity.ok(response);
    }
}

