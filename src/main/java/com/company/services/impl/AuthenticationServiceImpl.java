package com.company.services.impl;


import com.company.config.CustomSecurityContext;
import com.company.dto.request.LoginRequest;
import com.company.dto.request.RegisterRequest;
import com.company.dto.response.LoginResponse;
import com.company.entities.User;
import com.company.entities.UserType;
import com.company.repositories.UserRepository;
import com.company.repositories.UserTypeRepository;
import com.company.security.CustomUserDetails;
import com.company.security.JwtTokenService;
import com.company.services.inter.AuthenticationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl extends AuthenticationService {
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CustomSecurityContext securityContext;
    private final UserTypeRepository userTypeRepository;

    @Override
    @Transactional
    public LoginResponse register(RegisterRequest registerRequest) {
        User user = RegisterRequest.conveteUserResponseToUser(registerRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserType userType = userTypeRepository.findById(1L).orElseThrow();
        user.setUserType(userType);
        user.setStatus(true);
        CustomUserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getEmail(), user.getPassword(), true, true, true, true);
        String token = jwtTokenService.generateAccessToken(userDetails);
        userRepository.save(user);
        return new LoginResponse(token);
    }

    @Override
    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {
        String login = null;
        if (loginRequest.username() != null)
            login = loginRequest.username();
        else if (loginRequest.email() != null)
            login = loginRequest.email();
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, loginRequest.password()));
        User user = userRepository.findByUsernameOrEmail(loginRequest.username(), loginRequest.email()).orElseThrow(
                () -> new IllegalArgumentException(STR."\{loginRequest.email()}" + STR."\{loginRequest.username()}" + " username or email not found"));
        securityContext.setSecurityContext(authenticate);
        CustomUserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getEmail(), user.getPassword(), true, true, true, true);
        String accessToken = jwtTokenService.generateAccessToken(userDetails);
        return new LoginResponse(accessToken);
    }

}
