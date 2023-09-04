package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;

public interface CreateUserUseCase {

    UserResponse createUser(CreateUserRequest request);

}
