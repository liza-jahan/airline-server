package com.lina.airline.controller;

import com.lina.airline.dto.request.AuthenticationRequest;
import com.lina.airline.dto.response.AuthenticationResponse;
import com.lina.airline.service.AuthenticationService;
import com.lina.airline.utils.ApplicationConstantsUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authRequest) {
        String userEntity = authenticationService.loginUser(authRequest);
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstantsUtils.JWT_HEADER, userEntity)
                .body(new AuthenticationResponse(HttpStatus.OK.getReasonPhrase(), userEntity));
    }

}


