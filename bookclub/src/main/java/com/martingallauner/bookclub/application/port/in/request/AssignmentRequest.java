package com.martingallauner.bookclub.application.port.in.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static com.martingallauner.bookclub.common.Validation.validate;

public record AssignmentRequest(@NotNull Long userId, @NotNull @NotBlank String isbn) {

    public AssignmentRequest(Long userId, String isbn) {
        this.userId = userId;
        this.isbn = isbn;
        validate(this);
    }
}
