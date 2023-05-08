package com.martingallauner.bookclub.user;

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
}
