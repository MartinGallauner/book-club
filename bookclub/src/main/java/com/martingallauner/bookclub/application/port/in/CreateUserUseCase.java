package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;

public interface CreateUserUseCase {

    UserEntity createUser(CreateUserRequest request);

}
