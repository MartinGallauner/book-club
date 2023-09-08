package com.martingallauner.bookclub.application.port.in.response;

public record UserResponse(
        Long id,
        String name,
        String createdAt) {
}
