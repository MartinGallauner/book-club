package com.martingallauner.bookclub.application.port.in.response;

import java.util.Set;

public record UserResponse(Long id, String name, String createdAt) {
}
