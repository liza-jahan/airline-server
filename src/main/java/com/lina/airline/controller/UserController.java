package com.lina.airline.controller;


import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
