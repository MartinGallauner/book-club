package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.adapter.out.persistence.User;

public interface CreateUserUseCase {

    User createUser(CreateUserRequest request);

}
