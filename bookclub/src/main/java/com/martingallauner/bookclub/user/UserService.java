package com.martingallauner.bookclub.user;

import com.martingallauner.bookclub.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final Clock clock;

    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setPassword(request.password());
        user.setCreatedAt(LocalDateTime.now(clock));
        return userRepository.save(user);
    }

    public void addBook(Long userId, Book book) {
        User user = userRepository.getReferenceById(userId);
        user.getBooks().add(book);
        userRepository.save(user);
    }

    public void addConnection(ConnectUserRequest request) {
        User user1 = userRepository.findById(request.user1Id())
                .orElseThrow(() -> new RuntimeException("Person not found with id " + request.user1Id()));
        User user2 = userRepository.findById(request.user2Id())
                .orElseThrow(() -> new RuntimeException("Person not found with id " + request.user2Id()));

        user1.addConnection(user2);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
