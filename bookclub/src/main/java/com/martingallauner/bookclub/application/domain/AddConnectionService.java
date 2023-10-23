package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.in.AddConnectionUseCase;
import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddConnectionService implements AddConnectionUseCase {

    private final UserRepository userRepository;

    @Override
    public void addConnection(ConnectUserRequest request) {
        UserEntity user1 = userRepository.findById(request.primaryUserId())
                .orElseThrow(() -> new RuntimeException("Person not found with id " + request.primaryUserId()));
        UserEntity user2 = userRepository.findById(request.secondaryUserId())
                .orElseThrow(() -> new RuntimeException("Person not found with id " + request.secondaryUserId()));

        if (user1.getConnections().contains(user2)) {
            throw new IllegalArgumentException("Users are already connected");
        }

        user1.addConnection(user2);
        userRepository.save(user1);
    }
}
