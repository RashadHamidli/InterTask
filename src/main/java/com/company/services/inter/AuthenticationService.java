package com.company.services.inter;


import com.company.dto.request.LoginRequest;
import com.company.dto.request.RegisterRequest;
import com.company.dto.response.LoginResponse;

public abstract class AuthenticationService {

    public abstract LoginResponse register(RegisterRequest registerRequest);

    public abstract LoginResponse login(LoginRequest loginRequest);

}
