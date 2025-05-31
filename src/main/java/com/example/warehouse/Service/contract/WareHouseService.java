package com.example.warehouse.Service.contract;

import com.example.warehouse.dto.request.WarehouseRequest;
import com.example.warehouse.dto.response.WarehouseResponse;

public interface WareHouseService {
    WarehouseResponse addWarehouse(WarehouseRequest warehouseRequest,String userId);
}
