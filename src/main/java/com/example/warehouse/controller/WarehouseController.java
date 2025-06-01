package com.example.warehouse.controller;

import com.example.warehouse.Service.contract.WareHouseService;
import com.example.warehouse.dto.request.WarehouseRequest;
import com.example.warehouse.dto.response.WarehouseResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {
    @Autowired
    private WareHouseService service;
@PreAuthorize("hasAuthority('ADMIN')")
@PostMapping("/warehouse/{userId}")
    public ResponseEntity<ResponseStructure<WarehouseResponse>>registerWarehouse(@RequestBody WarehouseRequest warehouseRequest ,@PathVariable String userId){
    WarehouseResponse res=service.addWarehouse(warehouseRequest,userId);
    ResponseStructure<WarehouseResponse> resp=new ResponseStructure<>(HttpStatus.CREATED.value(),"Warehouse is being Created",res);
    return new ResponseEntity<ResponseStructure<WarehouseResponse>>(resp,HttpStatus.CREATED);
}
}
