package com.example.warehouse.dto.response;

import java.time.Instant;

public record UserResponse(
       String userId,
       String username,
       String email,
       String userRole,
       Long createdAt,
       Long lastModifiedAt
) {
}
