package com.company.controllers;

import com.company.dto.request.LoginRequest;
import com.company.dto.request.RegisterRequest;
import com.company.dto.response.LoginResponse;
import com.company.services.inter.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthRestController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public LoginResponse register(@RequestBody RegisterRequest registerRequest){
        return authenticationService.register(registerRequest);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }

}

