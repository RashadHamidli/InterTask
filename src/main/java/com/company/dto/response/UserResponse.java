package com.company.dto.response;

import com.company.entities.Permission;
import com.company.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(String username,
                           String name,
                           String surname,
                           String phoneNumber,
                           String email,
                           LocalDateTime createdAt,
                           LocalDateTime updateAt,
                           String userTypeName,
                           List<String> permissionName) {
    public static UserResponse of(User user) {
        return new UserResponse(user.getUsername(), user.getName(), user.getSurname(), user.getPhoneNumber(), user.getEmail(),
                user.getCreatedAt(), user.getUpdatedAt(), user.getUserType().getName(), user.getPermissions().stream().map(Permission::getName).toList());
    }
}
