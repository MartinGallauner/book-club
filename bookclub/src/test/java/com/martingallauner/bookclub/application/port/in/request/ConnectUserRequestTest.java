package com.martingallauner.bookclub.application.port.in.request;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectUserRequestTest {

    @DisplayName("Testing input validation when creating a request to connect two users.")
    @Test
    void createInvalidConnectUserRequest() {
        assertThrows(ConstraintViolationException.class, () -> new ConnectUserRequest(null, null));
    }

}
