package com.martingallauner.bookclub.application.port.in.request;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentRequestTest {

    @DisplayName("Testing input validation when creating a request to a book to an user.")
    @Test
    void createInvalidConnectUserRequest() {
        assertThrows(ConstraintViolationException.class, () -> new ConnectUserRequest(null, null));
    }

}
