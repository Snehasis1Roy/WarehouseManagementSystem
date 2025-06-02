package com.example.warehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RackBlockNotCreatedException extends RuntimeException{
    private final String message;
}
