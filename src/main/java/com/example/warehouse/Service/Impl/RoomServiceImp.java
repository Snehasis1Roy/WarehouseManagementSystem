package com.example.warehouse.Service.Impl;

import com.example.warehouse.Mapper.RoomMapper;
import com.example.warehouse.Repositery.RoomRepo;
import com.example.warehouse.Repositery.WarehouseRepo;
import com.example.warehouse.Service.contract.RoomService;
import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;
import com.example.warehouse.exception.roomHandler.RoomNotSavedException;
import com.example.warehouse.exception.warehousehandler.WarehouseNotFoundException;
import com.example.warehouse.model.Rooms;
import com.example.warehouse.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    private WarehouseRepo warehouseRepo;
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
     private RoomMapper roomMapper;

    @Override
    public RoomResponse createRoom(RoomRequest roomRequest, String warehouseId) {
        Warehouse wh=warehouseRepo.findById(warehouseId).orElseThrow(()-> new WarehouseNotFoundException("This Warehouse Id is not valid"));
        if(wh!=null){
           Rooms rm= roomMapper.toEntity(roomRequest,new Rooms());
            rm.setWarehouse(wh);
            warehouseRepo.save(wh);
            roomRepo.save(rm);
            return roomMapper.toResponse(rm);
        }
        else
            throw  new RoomNotSavedException("Room not Created");

    }
}
