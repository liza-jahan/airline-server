package com.lina.airline.filter;

import com.lina.airline.utils.ApplicationConstantsUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    @Value(ApplicationConstantsUtils.JWT_SECRET_DEFAULT_VALUE) // Injects the JWT secret key
    private String jwtSecret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder().setIssuer("Airline Server").setSubject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("authority", authentication.getAuthorities().stream().map(
                            GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + 3000000))
                    .signWith(secretKey).compact();
            response.setHeader(ApplicationConstantsUtils.JWT_HEADER, jwt);

        }
        filterChain.doFilter(request, response);
    }

}


