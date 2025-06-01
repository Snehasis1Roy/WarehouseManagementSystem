package com.example.warehouse.exception.roomHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomNotSavedException extends RuntimeException{
    private  final String message;
}
