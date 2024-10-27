package com.lina.airline.controller;

import com.lina.airline.dto.request.AuthenticationRequest;
import com.lina.airline.dto.response.AuthenticationResponse;
import com.lina.airline.utils.ApplicationConstantsUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Value(ApplicationConstantsUtils.JWT_SECRET_DEFAULT_VALUE)
    private String jwtSecretValue;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authRequest) {

        String jwt = "";
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(authRequest.email(),
                authRequest.password());
        Authentication authenticationResponse = authenticationManager.authenticate(authentication);
        if (authenticationResponse != null && authenticationResponse.isAuthenticated()) {
            SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecretValue.getBytes(StandardCharsets.UTF_8));
            jwt = Jwts.builder()
                    .setIssuer("Airline Server")
                    .setSubject("JWT token")
                    .claim("username", authentication.getName())
                    .claim("authorities", authentication.getAuthorities().stream().map(
                            GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + 30000000))
                    .signWith(secretKey).compact();
        }
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstantsUtils.JWT_HEADER, jwt).body(new AuthenticationResponse(HttpStatus.OK.getReasonPhrase(), jwt));
    }

}


//
//
//    HttpHeaders headers = new HttpHeaders();
//        if (response.getJwt() != null) {
//                headers.set(ApplicationConstants.JWT_HEADER, response.getJwt());
//                }
//
//                return ResponseEntity.status(HttpStatus.OK)
//                .headers(headers)
//                .body(response);
//                }