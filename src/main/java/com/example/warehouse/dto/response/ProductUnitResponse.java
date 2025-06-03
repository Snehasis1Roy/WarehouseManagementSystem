package com.example.warehouse.dto.response;

import com.example.warehouse.model.InboundBatch;
import com.example.warehouse.model.InboundShipment;
import com.example.warehouse.model.Product;

public record ProductUnitResponse(
        String unitId,
        String location,
        InboundShipment inboundShipment,
        InboundBatch inboundBatch,
        Product product
) {

}
