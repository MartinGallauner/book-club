package com.martingallauner.bookclub.application.port.in;

import org.jetbrains.annotations.NotNull;

public record CreateUserRequest(@NotNull String name, @NotNull String password) {

}
