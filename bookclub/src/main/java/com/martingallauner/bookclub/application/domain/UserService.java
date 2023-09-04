package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.application.port.in.AddConnectionUseCase;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.in.CreateUserUseCase;
import com.martingallauner.bookclub.application.port.in.GetUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserUseCase, CreateUserUseCase, AddConnectionUseCase {

    private final UserRepository userRepository;

    private final Clock clock;

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public UserEntity createUser(CreateUserRequest request) {
        UserEntity user = new UserEntity();
        user.setName(request.name());
        user.setPassword(request.password());
        user.setCreatedAt(LocalDateTime.now(clock));
        return userRepository.save(user);
    }

    public void addBook(Long userId, BookEntity book) {
        UserEntity user = userRepository.getReferenceById(userId);
        user.getBooks().add(book);
        userRepository.save(user);
    }

    @Override
    public void addConnection(ConnectUserRequest request) {
        UserEntity user1 = userRepository.findById(request.user1Id())
                .orElseThrow(() -> new RuntimeException("Person not found with id " + request.user1Id()));
        UserEntity user2 = userRepository.findById(request.user2Id())
                .orElseThrow(() -> new RuntimeException("Person not found with id " + request.user2Id()));

        user1.addConnection(user2);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
