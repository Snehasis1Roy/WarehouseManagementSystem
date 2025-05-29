package com.example.warehouse.dto.request;

public record UserRegistationRequest(
        String username,
        String email,
        String password
) {
}
