package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.TimeService;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TimeService timeService;

    @Test
    void getUserById() {
        when(userRepository.getReferenceById(1L))
                .thenReturn(UserEntity.builder()
                .id(1L)
                .name("Test User")
                .books(Set.of(BookEntity.builder().title("Test Title").author("Test Author").build()))
                .connections(List.of(UserEntity.builder().name("Test Friend").build()))
                .createdAt(LocalDateTime.of(2023, 9, 07, 07, 39))
                .build());

        UserModel user = userService.getUserById(1L);

        Assertions.assertEquals(1L, user.getId());
        Assertions.assertEquals("Test User", user.getName());
        Assertions.assertEquals("Test Title", user.getBooks().get(0).getTitle());
        Assertions.assertEquals("Test Author", user.getBooks().get(0).getAuthor());
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
