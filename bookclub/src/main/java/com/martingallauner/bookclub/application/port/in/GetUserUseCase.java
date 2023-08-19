package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.user.User;

public interface GetUserUseCase {

    User getUserById(Long id);
}
