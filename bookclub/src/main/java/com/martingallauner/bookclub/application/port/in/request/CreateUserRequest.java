package com.martingallauner.bookclub.application.port.in.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static com.martingallauner.bookclub.common.Validation.validate;

public record CreateUserRequest(
        @NotNull @NotBlank @Size(min = 3, max = 20) String name,
        @NotNull @NotBlank @Size(min = 6, max = 30) String password) {

    public CreateUserRequest(
            String name,
            String password) {

        this.name = name;
        this.password = password;
        validate(this);
    }
}
