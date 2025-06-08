package com.example.warehouse.dto.response;

import com.example.warehouse.enums.ShipmentStatus;

public record InboundShipmentResponse(
        String shipmentId,
        ProductResponse product,
        String sellerId,
        ShipmentStatus status
) {
}
