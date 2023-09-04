package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;

public interface CreateUserUseCase {

    UserModel createUser(CreateUserRequest request);

}
