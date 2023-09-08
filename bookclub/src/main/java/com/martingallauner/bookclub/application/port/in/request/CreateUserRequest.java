package com.martingallauner.bookclub.application.port.in.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static com.martingallauner.bookclub.common.Validation.validate;

public record CreateUserRequest(@NotBlank String name, @NotNull String password) {

    public CreateUserRequest(
            String name,
            String password) {

        this.name = name;
        this.password = password;
        validate(this);

    }

}
