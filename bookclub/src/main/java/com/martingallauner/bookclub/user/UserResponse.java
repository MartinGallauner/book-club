package com.martingallauner.bookclub.user;

import java.util.Set;

public record UserResponse(Long id, String name, String createdAt, Set<Long> connectionIds) {
}
