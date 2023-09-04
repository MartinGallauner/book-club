package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.port.in.response.UserResponse;

public interface GetUserUseCase {

    UserResponse getUserById(Long id);
}
