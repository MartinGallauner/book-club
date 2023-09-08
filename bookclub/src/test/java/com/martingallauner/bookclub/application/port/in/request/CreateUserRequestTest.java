package com.martingallauner.bookclub.application.port.in.request;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserRequestTest {

    @DisplayName("Testing input validation when creating a new user.")
    @Test
    void createInvalidUser() {
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest(null, null));
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest("", ""));
    }
}
