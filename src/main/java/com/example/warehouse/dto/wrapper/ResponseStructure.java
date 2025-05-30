package com.example.warehouse.dto.wrapper;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor( access = AccessLevel.PUBLIC)
public class ResponseStructure<T> {

    int statusCode;
    String message;
    T data;
}
