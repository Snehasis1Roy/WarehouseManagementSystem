package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.WarehouseRequest;
import com.example.warehouse.dto.response.WarehouseResponse;
import com.example.warehouse.model.Warehouse;
import org.springframework.stereotype.Controller;

@Controller
public class WarehouseMapper {

    public Warehouse toEntity(WarehouseRequest source,Warehouse target){
      target.setWarehouseName(source.warehouseName());
      target.setCity(source.city());
      target.setAddress(source.address());
      target.setLandmark(source.landmark());
      return target;
    }

    public WarehouseResponse toResponse(Warehouse warehouse){
        return new WarehouseResponse(
            warehouse.getWarehouseName(),
            warehouse.getAddress(),
            warehouse.getCity()
        );
    }
}
