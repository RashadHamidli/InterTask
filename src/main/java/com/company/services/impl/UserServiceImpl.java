package com.company.services.impl;

import com.company.dto.response.UserResponse;
import com.company.entities.User;
import com.company.repositories.UserRepository;
import com.company.services.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse getOneUserFullInfo(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new IllegalArgumentException(STR."\{username} not found"));
        return UserResponse.of(user);
    }
}
