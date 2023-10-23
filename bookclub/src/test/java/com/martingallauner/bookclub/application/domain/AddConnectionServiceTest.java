package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddConnectionServiceTest {

    @InjectMocks
    private AddConnectionService addConnectionService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("When connecting users, throw exception if user are already connected.")
    @Test
    void addConnection_already_connected() {
        //given
        ConnectUserRequest request = new ConnectUserRequest(1L, 2L);

        UserEntity user1 = new UserEntity(1L, "user1", "password", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>());
        UserEntity user2 = new UserEntity(2L, "user2", "password", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>());

        user1.addConnection(user2);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user2));

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            addConnectionService.addConnection(request);
        });


    }
}
