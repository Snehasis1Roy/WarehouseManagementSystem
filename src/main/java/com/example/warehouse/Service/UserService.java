package com.example.warehouse.Service;

import com.example.warehouse.dto.request.UserRegistationRequest;
import com.example.warehouse.dto.response.UserResponse;


public interface UserService {
    UserResponse CreateNewUser(UserRegistationRequest userRegistationRequest);
}
