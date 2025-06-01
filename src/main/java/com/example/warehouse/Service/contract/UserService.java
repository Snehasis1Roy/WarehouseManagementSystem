package com.example.warehouse.Service.contract;

import com.example.warehouse.dto.request.UserRegistationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;


public interface UserService {
    UserResponse CreateNewUser(UserRegistationRequest userRegistationRequest);
    UserResponse UpdateExistingUser(UserRequest userRequest);

    UserResponse findById();
}
