package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.TimeService;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.port.in.AddConnectionUseCase;
import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements AddConnectionUseCase {

    private final UserRepository userRepository;

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
