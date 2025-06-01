package com.example.warehouse.controller;

import com.example.warehouse.Service.contract.RoomService;
import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {
    @Autowired
    private RoomService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/createroom/{warehouseId}")
    public ResponseEntity<ResponseStructure<RoomResponse>>createNewRoom(@RequestBody RoomRequest roomRequest, @PathVariable String warehouseId){
        RoomResponse rm= service.createRoom(roomRequest,warehouseId);
        ResponseStructure<RoomResponse> rs= new ResponseStructure<>(HttpStatus.CREATED.value(), "Room successfully created",rm);
        return new ResponseEntity<>(rs,HttpStatus.CREATED);
    }
}
