package com.company.services.inter;

import com.company.dto.response.UserResponse;

public abstract class UserService {
    public abstract UserResponse getOneUserFullInfo(String username);
}
