package com.example.warehouse.controller;

import com.example.warehouse.Service.contract.RackService;
import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.model.Block;
import com.example.warehouse.model.Rack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RackController {
    @Autowired
    private RackService rackService;

    @PostMapping("/rack/{blockId}")
    public ResponseEntity<ResponseStructure<RackResponse>>createNewRack(@RequestBody  RackRequest rackRequest, @PathVariable String blockId ){
        RackResponse rackResponse= rackService.createNewRack(rackRequest,blockId);
        ResponseStructure responseStructure= new ResponseStructure(HttpStatus.CREATED.value(), "rack Created",rackResponse);
        return null;
    }



}
