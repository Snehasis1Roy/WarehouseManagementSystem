package com.example.warehouse.Service.contract;

import com.example.warehouse.dto.request.InboundShipmentRequest;
import com.example.warehouse.dto.response.InboundShipmentResponse;

public interface InboundShipmentService {
    InboundShipmentResponse registerInboundShipment(InboundShipmentRequest inboundShipmentRequest, String warehouseId);
}
