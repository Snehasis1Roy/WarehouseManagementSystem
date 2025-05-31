package com.example.warehouse.exception.warehousehandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WarehouseNotRegisterException extends RuntimeException {
    private final String  message;
    }

