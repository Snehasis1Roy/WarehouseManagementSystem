package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.ProductUnitRequest;
import com.example.warehouse.dto.response.ProductUnitResponse;
import com.example.warehouse.model.InboundBatch;
import com.example.warehouse.model.InboundShipment;
import com.example.warehouse.model.ProductUnit;
import org.springframework.stereotype.Component;

@Component
public class ProductUnitMapper {

   private InboundBatchMapper InboundBatchMapper;


     public ProductUnit toEntity(ProductUnitRequest source, ProductUnit target, InboundShipment Shipment) {
         if (source == null || target == null) {
             return null;
         }
         target.setLocation(null);
         // The following assignments require additional logic, such as fetching from DB or using other mappers
          target.setInboundBatch(InboundBatchMapper.toEntity(source.inboundBatchRequest(),new InboundBatch())); // Map InboundBatchRequest to InboundBatch entity
          target.setInboundShipment(Shipment); // Fetch InboundShipment by ShipmentId
         return target;
     }

     public ProductUnitResponse toResponse(ProductUnit productUnit){
         if (productUnit == null) {
             return null;
         }
         return new ProductUnitResponse(
             productUnit.getUnitId(),
             productUnit.getLocation(),
             productUnit.getInboundShipment(),
             productUnit.getInboundBatch(),
             productUnit.getProduct()
         );
     }
}
