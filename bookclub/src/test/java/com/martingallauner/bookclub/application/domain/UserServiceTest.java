package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.application.TimeService;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TimeService timeService;


    @Test
    void getUserById() {

    }

    @Test
    void createUser() {
    }

    @Test
    void addBook() {
    }

    @Test
    void addConnection() {
    }
}
