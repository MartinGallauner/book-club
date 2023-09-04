package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.TimeService;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.AddConnectionUseCase;
import com.martingallauner.bookclub.application.port.in.CreateUserUseCase;
import com.martingallauner.bookclub.application.port.in.GetUserUseCase;
import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements GetUserUseCase, CreateUserUseCase, AddConnectionUseCase {

    private final UserRepository userRepository;

    private final TimeService timeService;


    @Override
    public UserModel getUserById(Long id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        return UserModel.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .books(userEntity.getBooks().stream().map(BookEntity::toModel).collect(Collectors.toSet()))
                .connections(userEntity.getConnections().stream().map(UserEntity::toModel).collect(Collectors.toSet()))
                .createdAt(userEntity.getCreatedAt())
                .build();
    }

    @Override
    public UserModel createUser(CreateUserRequest request) {
        UserEntity user = UserEntity.builder()
                .name(request.name())
                .password(request.password())
                .createdAt(timeService.getLocalDateTime())
                .build();

        UserEntity userEntity = userRepository.save(user);

        return userEntity.toModel();
    }

    public void addBook(Long userId, BookModel book) {
        UserEntity user = userRepository.getReferenceById(userId);
        //todo implement adding of books
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
