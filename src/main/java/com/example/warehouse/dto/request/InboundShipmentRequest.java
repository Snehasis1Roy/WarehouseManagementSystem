package com.example.warehouse.dto.request;

import com.example.warehouse.enums.ShipmentStatus;

public record InboundShipmentRequest(
        String sellerId,
        ProductRequest product,
        ShipmentStatus status,
        int quantity
) {
}
