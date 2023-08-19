package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.user.CreateUserRequest;
import com.martingallauner.bookclub.application.domain.user.User;

public interface CreateUserUseCase {

    User createUser(CreateUserRequest request);

}
