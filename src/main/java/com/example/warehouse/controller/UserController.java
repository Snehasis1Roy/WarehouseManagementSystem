package com.example.warehouse.controller;



import com.example.warehouse.ServiceImp.UserServiceImp;
import com.example.warehouse.dto.request.UserRegistationRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImp userService;
    @PostMapping
    public ResponseEntity<ResponseStructure<UserResponse>> creastingNewUser(@RequestBody UserRegistationRequest userRegistationRequest){
        System.out.println(userRegistationRequest);
        UserResponse us = userService.CreateNewUser(userRegistationRequest);
        ResponseStructure<UserResponse> responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(),"User created",us);
        return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.CREATED);
    }

}
