package com.martingallauner.bookclub.application.port.in.request;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserRequestTest {

    @Test
    void createInvalidUser() {

        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest(null, null));

    }

}
