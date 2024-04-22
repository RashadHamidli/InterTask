package com.company.dto.request;

import com.company.entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegisterRequest(String username,
                              String password,
                              String name,
                              String surname,
                              String phoneNumber,
                              String email,
                              LocalDate createdAt) {

    public static User conveteUserResponseToUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.username);
        user.setPassword(registerRequest.password);
        user.setName(registerRequest.name);
        user.setSurname(registerRequest.surname);
        user.setPhoneNumber(registerRequest.phoneNumber);
        user.setEmail(registerRequest.email);
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

}
