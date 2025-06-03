package com.example.warehouse.dto.response;

import com.example.warehouse.model.ProductUnit;

import java.util.List;

public record InboundBatchResponse(
        String batchCode,
        int countOfRejectedUnit,
        int countOfAcceptedUnit
) {
}
