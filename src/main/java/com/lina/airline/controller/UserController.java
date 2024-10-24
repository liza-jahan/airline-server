package com.lina.airline.controller;


import com.lina.airline.dto.APIResponse;
import com.lina.airline.dto.request.UpdateUserRequest;
import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.dto.response.CreationResponse;
import com.lina.airline.entity.UserEntity;
import com.lina.airline.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
//@RequestMapping("/api/v1'")
@RequiredArgsConstructor
public class UserController {

   public final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse<CreationResponse>> registrationUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest){
       UUID id=userService.saveUser(userRegistrationRequest);
        APIResponse<CreationResponse> responseDTO = APIResponse
                .<CreationResponse>builder()
                .dateTime(new Date().toString())
                .status(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK)
                .results(new CreationResponse(id))
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
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
}

