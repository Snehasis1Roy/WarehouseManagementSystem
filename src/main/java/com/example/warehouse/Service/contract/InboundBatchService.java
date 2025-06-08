package com.example.warehouse.Service.contract;

import com.example.warehouse.dto.request.InboundBatchRequest;
import com.example.warehouse.dto.response.InboundBatchResponse;

public interface InboundBatchService {
    InboundBatchResponse createBatch(InboundBatchRequest inboundBatchRequest,String shipmentId);
}
