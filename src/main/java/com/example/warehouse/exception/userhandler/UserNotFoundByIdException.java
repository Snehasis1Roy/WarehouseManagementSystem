package com.example.warehouse.exception.userhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserNotFoundByIdException extends RuntimeException{
    private final String message;
}
