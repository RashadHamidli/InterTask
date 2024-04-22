package com.company.controllers;

import com.company.dto.response.UserResponse;
import com.company.services.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;

    @GetMapping
    private UserResponse getOneUserFullInfo(String username){
        return userService.getOneUserFullInfo(username);
    }

}
