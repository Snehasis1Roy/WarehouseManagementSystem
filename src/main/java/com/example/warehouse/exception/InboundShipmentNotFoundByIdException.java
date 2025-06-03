package com.example.warehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class InboundShipmentNotFoundByIdException extends RuntimeException {
    private final String message;
}
