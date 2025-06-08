package com.example.warehouse.dto.response;

import com.example.warehouse.enums.ShipmentStatus;
import com.example.warehouse.model.Product;

public record InboundShipmentResponse(
        String shipmentId,
        Product product,
        String sellerId,
        ShipmentStatus status,
        int quantity
) {
}
