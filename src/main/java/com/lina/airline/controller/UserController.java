package com.lina.airline.controller;


import com.lina.airline.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

   //public final UserService userService;

    @GetMapping
    public String getMessage(){
        return "Hello";
    }
}
