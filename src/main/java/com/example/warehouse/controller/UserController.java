package com.example.warehouse.controller;



import com.example.warehouse.Service.Impl.UserServiceImp;
import com.example.warehouse.dto.request.UserRegistationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServiceImp userService;
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> creastingNewUser(@RequestBody UserRegistationRequest userRegistationRequest){

        UserResponse us = userService.CreateNewUser(userRegistationRequest);
        ResponseStructure<UserResponse> responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(),"User created",us);
        return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure, HttpStatus.CREATED);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> UpdatingUser(@RequestBody UserRequest userRequest,@PathVariable String userId){
        UserResponse us = userService.UpdateExistingUser(userRequest,userId);
        ResponseStructure<UserResponse>responseStructure= new ResponseStructure<>(HttpStatus.CREATED.value(),"Updation is successfully complited",us);
        return  new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.CREATED);

    }
    @GetMapping("/findId/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>>findById(@PathVariable String userId){
        UserResponse us=userService.findById(userId);
        ResponseStructure<UserResponse>responseStructure=new ResponseStructure<>(HttpStatus.FOUND.value(), "User Found Successfully",us);
        return new ResponseEntity<ResponseStructure<UserResponse>>(responseStructure,HttpStatus.FOUND);
    }

}
