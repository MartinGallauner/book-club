package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.TimeService;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserServiceTest {

    @InjectMocks
    private GetUserService GetUserService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("Get user by id, happy path.")
    @Test
    void getUserById() {
        when(userRepository.getReferenceById(1L))
                .thenReturn(UserEntity.builder()
                .id(1L)
                .name("Test User")
                .books(List.of(BookEntity.builder().title("Test Title").author("Test Author").build()))
                .connections(List.of(UserEntity.builder().name("Test Friend").build()))
                .createdAt(LocalDateTime.of(2023, 9, 7, 7, 39))
                .build());

        UserModel user = GetUserService.getUserById(1L);

        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getName()).isEqualTo("Test User");
        assertThat(user.getCreatedAt()).isEqualTo(LocalDateTime.of(2023, 9, 7, 7, 39));
    }

}
