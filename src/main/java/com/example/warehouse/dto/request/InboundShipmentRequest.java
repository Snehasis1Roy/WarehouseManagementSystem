package com.example.warehouse.dto.request;

import com.example.warehouse.enums.ShipmentStatus;

public record InboundShipmentRequest(
        String customerId,
        ProductRequest product,
        ShipmentStatus status
) {
}
