package com.example.warehouse.dto.response;

import com.example.warehouse.enums.BlockType;

public record BlockResponse(
        String blockId,
        BlockType type,
        double length,
        double bredth,
        double height
) {
}
