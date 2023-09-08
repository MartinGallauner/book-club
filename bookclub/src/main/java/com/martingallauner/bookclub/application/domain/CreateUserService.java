package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.TimeService;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.CreateUserUseCase;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateUserService implements CreateUserUseCase {

    private final UserRepository userRepository;

    private final TimeService timeService;

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
}
