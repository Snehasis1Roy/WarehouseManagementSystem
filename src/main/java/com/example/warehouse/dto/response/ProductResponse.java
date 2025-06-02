package com.example.warehouse.dto.response;

public record ProductResponse(
        String title,
        double weight,
        double height,
        double length,
        String materialType,
        int quantity,
        double productPrice,
        String careInstruction
) {
}
