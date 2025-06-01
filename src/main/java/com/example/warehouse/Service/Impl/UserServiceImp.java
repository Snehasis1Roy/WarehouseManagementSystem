package com.example.warehouse.Service.Impl;
import com.example.warehouse.Mapper.UserMapper;
import com.example.warehouse.Repositery.UserRepo;
import com.example.warehouse.Service.contract.UserService;
import com.example.warehouse.dto.request.UserRegistationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.exception.UserNotLoggedInException;
import com.example.warehouse.exception.UserRoleNotValidException;
import com.example.warehouse.model.Admin;
import com.example.warehouse.model.Staff;
import com.example.warehouse.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.example.warehouse.security.AuthUtils.*;


@Service
@Slf4j
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo repositery;
    @Autowired
    private UserMapper userMapper;
    @Autowired
     private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse CreateNewUser(UserRegistationRequest userRegistationRequest) {
        log.debug("Registering user {}, is-email-present: {}", userRegistationRequest.email(), userRegistationRequest.email()!=null);
        User user = switch (userRegistationRequest.userRole()){
            case ADMIN -> userMapper.userToEntity(userRegistationRequest,new Admin());
            case STAFF -> userMapper.userToEntity(userRegistationRequest,new Staff());
            default -> throw new UserRoleNotValidException("Unsupported user role!!");
        };

        if (user != null) {
            log.debug("Resolved user '{}', with role '{}' ", user.getEmail(), user.getUserRole());
            String password=passwordEncoder.encode(user.getPassword());
            user.setPassword(password);
            repositery.save(user);
        } else {
            log.error("Failed to resolve user, Can be a Invalid UserRole.", new IllegalStateException("Invalid User role; Couldn't resolve user."));
        }
        return userMapper.toUserResponse(user);
    }
    @Override
    public UserResponse UpdateExistingUser(UserRequest userRequest) {
      User existingUser = getCurrentUserName().
               map(username->repositery.findByEmail(username)
                       .orElseThrow(()->new UsernameNotFoundException("User Not Found!")))
                       .orElseThrow(()->new UserNotLoggedInException("User not Logged In yet!!"));
        User user=userMapper.userRequestToEntity(userRequest,existingUser);
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        repositery.save(user);
        return userMapper.toUserResponse(user);
    }
    @Override
    public UserResponse findById() {
        User user= getCurrentUserName().map(username->repositery.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Username not found!!")))
                .orElseThrow(()->new UserNotLoggedInException("User is not yet loggedin"));
        return userMapper.toUserResponse(user);
    }
}


