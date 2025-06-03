package com.example.warehouse.controller;

import com.example.warehouse.Service.contract.InboundBatchService;
import com.example.warehouse.dto.request.InboundBatchRequest;
import com.example.warehouse.dto.response.InboundBatchResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InboundBatchController {
    @Autowired
    private InboundBatchService inboundBatchService;

     @PostMapping("/batch/{shipmentId}")
    public ResponseEntity<ResponseStructure<InboundBatchResponse>>creatingBathces(@RequestBody InboundBatchRequest inboundBatchRequest, @PathVariable String shipmentId){
         InboundBatchResponse res= inboundBatchService.createBatch(inboundBatchRequest,shipmentId);
         ResponseStructure<InboundBatchResponse> RS= new ResponseStructure<>(HttpStatus.CREATED.value(), "The batch is successfuly created",res);
         return new ResponseEntity<>(RS,HttpStatus.CREATED);
     }
}
