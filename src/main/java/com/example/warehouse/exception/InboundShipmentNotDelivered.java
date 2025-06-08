package com.example.warehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InboundShipmentNotDelivered extends RuntimeException {
    private final String message;
}
