package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;
import com.example.warehouse.model.InboundShipment;
import org.springframework.stereotype.Component;

@Component
public class InboundShipmentMapper {

    public InboundShipment toEntity(InboundShipmentRequest source, InboundShipment target) {
        target.setCustomerId(source.customerId());
        target.setStatus(source.status());
        if (source.product() != null) {
            target.setProductTitle(source.product().title());
            target.setProductWeight(source.product().weight());
            target.setProductLength(source.product().length());
            target.setProductBreadth(source.product().bredth());
            target.setMaterialType(source.product().materialType());
            target.setCareInstruction(source.product().careinstruction());
            target.setQuantity(source.product().Quantity());
            target.setProductPrice(source.product().productPrice());
        }
        return target;
    }

    public InboundShipmentResponse toResponse(InboundShipment inboundShipment) {
        return new InboundShipmentResponse(
            inboundShipment.getShipmentId(),
            new com.example.warehouse.dto.response.ProductResponse(
                inboundShipment.getProductTitle(),
                inboundShipment.getProductWeight(),
                inboundShipment.getProductLength(),
                inboundShipment.getProductBreadth(),
                inboundShipment.getMaterialType(),
                inboundShipment.getQuantity(),
                inboundShipment.getProductPrice(),
                inboundShipment.getCareInstruction()
            ),
            inboundShipment.getCustomerId(),
            inboundShipment.getStatus()
        );
    }
}
