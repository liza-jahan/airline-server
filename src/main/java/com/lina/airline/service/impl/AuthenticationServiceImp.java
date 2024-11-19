package com.lina.airline.service.impl;

import com.lina.airline.dto.request.AuthenticationRequest;
import com.lina.airline.service.AuthenticationService;
import com.lina.airline.utils.ApplicationConstantsUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    @Value(ApplicationConstantsUtils.JWT_SECRET_DEFAULT_VALUE)
    private String jwtSecretValue;

    @Override
    public String loginUser(AuthenticationRequest authRequest) {
        try {
            // Create an authentication object with the user's credentials
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authRequest.email(), authRequest.password());

            Authentication authenticationResponse = authenticationManager.authenticate(authentication);

            if (authenticationResponse.isAuthenticated()) {
                SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecretValue.getBytes(StandardCharsets.UTF_8));

                return Jwts.builder()
                        .setIssuer("Airline Server")
                        .setSubject("JWT token")
                        .claim("username", authenticationResponse.getName())
                        .claim("authorities", authenticationResponse.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.joining(",")))
                        .setIssuedAt(new Date())
                        .setExpiration(new Date((new Date()).getTime() + 30000000))
                        .signWith(secretKey)
                        .compact();
            }
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials", e);
        }

        return null;
    }
}
