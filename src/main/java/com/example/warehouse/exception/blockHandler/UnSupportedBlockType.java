package com.example.warehouse.exception.blockHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UnSupportedBlockType extends RuntimeException{
    private final String message;
}
