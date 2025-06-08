package com.example.warehouse.Service.Impl;

import com.example.warehouse.Mapper.InboundShipmentMapper;
import com.example.warehouse.Repositery.InboundShipmentRepo;
import com.example.warehouse.Repositery.WarehouseRepo;
import com.example.warehouse.Service.contract.InboundShipmentService;
import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.exception.InboundShipmentNotDelivered;
import com.example.warehouse.exception.warehousehandler.WarehouseNotFoundException;
import com.example.warehouse.model.InboundShipment;
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
    @Override
    public InboundShipmentResponse registerInboundShipment(InboundShipmentRequest inboundShipmentRequest, String warehouseId) {
        Warehouse warehouse= warehouseRepo.findById(warehouseId).orElseThrow(()-> new WarehouseNotFoundException("warehouse not found by id "));
        if(warehouse!=null){
            InboundShipment inboundShipment= inboundShipmentMapper.toEntity(inboundShipmentRequest,new InboundShipment());
            inboundShipment.setWarehouse(warehouse);
            inboundShipmentRepo.save(inboundShipment);
            return inboundShipmentMapper.toResponse(inboundShipment);

        }
        else
            throw new InboundShipmentNotDelivered("data of the Inbound class Is not saved to  the Db ");

    }
}
