package com.example.warehouse.Service.Impl;

import com.example.warehouse.Mapper.WarehouseMapper;
import com.example.warehouse.Repositery.UserRepo;
import com.example.warehouse.Repositery.WarehouseRepo;
import com.example.warehouse.Service.contract.WareHouseService;
import com.example.warehouse.dto.request.WarehouseRequest;
import com.example.warehouse.dto.response.WarehouseResponse;
import com.example.warehouse.exception.userhandler.UserNotFoundByIdException;
import com.example.warehouse.exception.warehousehandler.WarehouseNotRegisterException;
import com.example.warehouse.model.Admin;
import com.example.warehouse.model.User;
import com.example.warehouse.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImp implements WareHouseService {
    @Autowired
    private WarehouseRepo warehouseRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public WarehouseResponse addWarehouse(WarehouseRequest warehouseRequest,String userId) {
        User user= userRepo.findById(userId).orElseThrow(()-> new UserNotFoundByIdException("User is not there"));
        if(user instanceof Admin admin)
        {
            Warehouse warehouse=warehouseMapper.toEntity(warehouseRequest,new Warehouse());
            admin.setWarehouse(warehouse);
            warehouseRepo.save(warehouse);
            userRepo.save(admin);
           return warehouseMapper.toResponse(warehouse);
        }
        else
            throw new WarehouseNotRegisterException("Due to unauthorised user warehouse cannot be created");
    }
}
