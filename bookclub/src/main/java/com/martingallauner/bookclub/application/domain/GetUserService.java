package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.GetUserUseCase;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserService implements GetUserUseCase {

    private final UserRepository userRepository;

    @Override
    public UserModel getUserById(Long id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        return userEntity.toModel();
    }
}
