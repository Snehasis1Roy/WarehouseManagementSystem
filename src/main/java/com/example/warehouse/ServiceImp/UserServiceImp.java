package com.example.warehouse.ServiceImp;


import com.example.warehouse.Mapper.UserMapper;
import com.example.warehouse.Repositery.UserRepo;
import com.example.warehouse.Service.UserService;
import com.example.warehouse.dto.request.UserRegistationRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.model.Admin;
import com.example.warehouse.model.Staff;
import com.example.warehouse.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo repositery;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse CreateNewUser(UserRegistationRequest userRegistationRequest) {
        log.debug("Registering user {}, is-email-present: {}", userRegistationRequest.email(), userRegistationRequest.email()!=null);
        User user = null;
        UserRole role = userRegistationRequest.userRole();

        switch (role) {
            case ADMIN -> user = userMapper.userToEntity(userRegistationRequest, new Admin());
            case STAFF -> user = userMapper.userToEntity(userRegistationRequest, new Staff());
        }

        if (user != null) {
            log.debug("Resolved user '{}', with role '{}' ", user.getEmail(), user.getUserRole());
            repositery.save(user);
        } else {
            log.error("Failed to resolve user, Can be a Invalid UserRole.", new IllegalStateException("Invalid User role; Couldn't resolve user."));
        }
        return userMapper.toUserResponse(user);
    }
}


