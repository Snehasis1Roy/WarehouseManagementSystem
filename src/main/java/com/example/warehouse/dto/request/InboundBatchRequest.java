package com.example.warehouse.dto.request;

public record InboundBatchRequest(
        int countOfRejectedUnit,
        int countOfAcceptedUnit
) {

}
