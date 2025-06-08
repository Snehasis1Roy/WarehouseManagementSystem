package com.example.warehouse.controller;

import com.example.warehouse.Service.contract.InboundShipmentService;
import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InboundShipmentController {
    @Autowired
    private InboundShipmentService inboundShipmentService;

    @PostMapping("/inboundShipment/{warehouseId}")
    public ResponseEntity<ResponseStructure<InboundShipmentResponse>>newInboundShipment(@RequestBody InboundShipmentRequest inboundShipmentRequest,@PathVariable String warehouseId){
        InboundShipmentResponse inboundShipmentResponse= inboundShipmentService.registerInboundShipment(inboundShipmentRequest,warehouseId);
        ResponseStructure<InboundShipmentResponse> res= new ResponseStructure<>(HttpStatus.CREATED.value(), "the Shipment is been register",inboundShipmentResponse);
        return new ResponseEntity<>(res,HttpStatus.CREATED);

    }

}
