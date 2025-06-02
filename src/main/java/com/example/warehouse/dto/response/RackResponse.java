package com.example.warehouse.dto.response;

public record RackResponse (
        String rackId,
        double length,
        double breadth,
        double height 
) {
}
