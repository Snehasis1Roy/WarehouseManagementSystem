package com.example.warehouse.dto.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseStructure<T> {

    int statusCode;
    String message;
    T data;
}
