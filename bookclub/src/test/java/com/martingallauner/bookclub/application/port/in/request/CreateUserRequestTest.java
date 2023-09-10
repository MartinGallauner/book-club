package com.martingallauner.bookclub.application.port.in.request;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserRequestTest {

    @DisplayName("Creating a user with null/empty credentials.")
    @Test
    void createInvalidUser() {
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest(null, null));
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest(null, null));
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest("", ""));
    }

    @DisplayName("Create a user with invalid username")
    @Test
    void createUserWithInvalidUsername() {
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest("abcdefghijklmnopqrstuvwxyz", "password"));
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest("ab", "password"));
    }

    @DisplayName("Create a user with invalid password")
    @Test
    void createUserWithInvalidPassword() {
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest("abc", "abcdefghijklmnopqrstuvwxyz0123456789"));
        assertThrows(ConstraintViolationException.class, () -> new CreateUserRequest("abc", "123"));
    }
}
