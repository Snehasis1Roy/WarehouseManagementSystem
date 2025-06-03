package com.example.warehouse.Service.Impl;

import com.example.warehouse.Mapper.InboundShipmentMapper;
import com.example.warehouse.Repositery.InboundShipmentRepo;
import com.example.warehouse.Repositery.ProductRepo;
import com.example.warehouse.Repositery.WarehouseRepo;
import com.example.warehouse.Service.contract.InboundShipmentService;
import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.exception.warehousehandler.WarehouseNotFoundException;
import com.example.warehouse.model.InboundShipment;
import com.example.warehouse.model.Product;
import com.example.warehouse.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundShipmentServiceImpl implements InboundShipmentService {
    @Autowired
    private InboundShipmentRepo inboundShipmentRepo;

    @Autowired
    private WarehouseRepo warehouseRepo;

    @Autowired
    private InboundShipmentMapper inboundShipmentMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public InboundShipmentResponse registerInboundShipment(InboundShipmentRequest inboundShipmentRequest, String warehouseId) {

      Product product = productRepo.findById(inboundShipmentRequest.product().productId()).orElse(null);
      if(product==null){
          product = inboundShipmentMapper.productToEntity(inboundShipmentRequest.product());
          product = productRepo.save(product);
      }
        Warehouse warehouse = warehouseRepo.findById(warehouseId).orElseThrow(()-> new WarehouseNotFoundException("warehouse not found by id "));
        InboundShipment inboundShipment = inboundShipmentMapper.toEntity(inboundShipmentRequest,new InboundShipment());
        inboundShipment.setProduct(product);
        inboundShipment.setWarehouse(warehouse);
        inboundShipmentRepo.save(inboundShipment);
        return inboundShipmentMapper.toResponse(inboundShipment);
    }
}
