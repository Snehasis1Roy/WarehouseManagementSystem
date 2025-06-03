package com.example.warehouse.dto.request;

public record ProductUnitRequest(
        String location,
        InboundBatchRequest inboundBatchRequest,
        String ShipmentId
) {
}
