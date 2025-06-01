package com.example.warehouse.controller;

import com.example.warehouse.Service.contract.BlockService;
import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlocksController {
    @Autowired
    private BlockService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/createBlock/{roomId}")
    public ResponseEntity<ResponseStructure<BlockResponse>> createNewBlock(@RequestBody BlockRequest blockRequest, @PathVariable String roomId){
        BlockResponse Br= service.createNewBlock(blockRequest,roomId);
        ResponseStructure rs= new ResponseStructure<>(HttpStatus.CREATED.value(), "Block Created Succesfully",Br);
        return new ResponseEntity<>(rs,HttpStatus.CREATED);
    }
}
