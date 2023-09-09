package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.TimeService;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserServiceTest {

    @InjectMocks
    private CreateUserService createUserService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TimeService timeService;

    @DisplayName("Create a new user - happy path.")
    @Test
    void createUser() {
        CreateUserRequest request = new CreateUserRequest("test user", "password");

        when(timeService.getLocalDateTime()).thenReturn(LocalDateTime.of(2023, 9, 9, 7, 56));
        when(userRepository.save(any(UserEntity.class))).thenAnswer(i -> {
            UserEntity userToSave = i.getArgument(0);
            userToSave.setId(99L);
            return userToSave;
        });

        UserModel result = createUserService.createUser(request);
        assertThat(result.getId()).isEqualTo(99L);
        assertThat(result.getName()).isEqualTo("test user");
        assertThat(result.getPassword()).isEqualTo("password");
        assertThat(result.getCreatedAt()).isEqualTo(LocalDateTime.of(2023, 9, 9, 7, 56));
    }
}
