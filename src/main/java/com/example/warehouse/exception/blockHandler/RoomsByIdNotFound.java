package com.example.warehouse.exception.blockHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoomsByIdNotFound extends RuntimeException{
    private final String message;
}
