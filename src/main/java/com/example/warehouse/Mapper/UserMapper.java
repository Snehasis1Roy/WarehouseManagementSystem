package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.UserRegistationRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public User userToEntity(UserRegistationRequest source, User target){
         target.setUsername(source.username());
         target.setUserRole(source.userRole());
         target.setEmail(source.email());
         target.setPassword(source.password());
         return target;
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getUserRole().name(),
                user.getCreatedAt().toEpochMilli(),
                user.getLastModifiedAt().toEpochMilli()
        );
    }
}
