package com.martingallauner.bookclub.application.port.in.request;

import jakarta.validation.constraints.NotNull;

import static com.martingallauner.bookclub.common.Validation.validate;

public record ConnectUserRequest(@NotNull Long primaryUserId, @NotNull Long secondaryUserId) {

    public ConnectUserRequest(Long primaryUserId, Long secondaryUserId) {
        this.primaryUserId = primaryUserId;
        this.secondaryUserId = secondaryUserId;
        validate(this);
    }

}
