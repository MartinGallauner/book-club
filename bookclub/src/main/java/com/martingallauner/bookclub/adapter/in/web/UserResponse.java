package com.martingallauner.bookclub.adapter.in.web;

import java.util.Set;

public record UserResponse(Long id, String name, String createdAt, Set<Long> connectionIds) {
}
