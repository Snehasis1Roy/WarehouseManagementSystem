package com.example.warehouse.dto.response;

public record ProductResponse(
        String title,
        double weight,
        double height,
        double length,
        String material,
        double price,
        String careInstruction,
        double breadth
) {
}
