package com.company.dto.request;

import com.company.entities.Role;
import com.company.entities.UserType;

import java.time.LocalDateTime;

public record UserTypeRequest(String name) {
    public static UserType converteUserTypeRequestToUserType(Long userTypeId) {
        UserType userType=new UserType();
        userType.setCreatedAt(LocalDateTime.now());
        userType.setName(Role.ADMIN.name());
        return userType;
    }
}
