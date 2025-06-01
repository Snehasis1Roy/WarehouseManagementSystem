package com.example.warehouse.Service.contract;

import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;

public interface RoomService {
    RoomResponse createRoom(RoomRequest roomRequest,String warehouseId);
}
