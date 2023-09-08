package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;

public interface CreateUserUseCase {

    UserModel createUser(CreateUserRequest request);

}
