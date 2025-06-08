package com.example.warehouse.dto.request;

import com.example.warehouse.enums.BlockType;

public record BlockRequest (
        BlockType type,
        double length,
        double bredth,
        double height
){
}
