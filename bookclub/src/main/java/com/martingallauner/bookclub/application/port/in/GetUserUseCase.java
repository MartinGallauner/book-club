package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.adapter.out.persistence.User;

public interface GetUserUseCase {

    User getUserById(Long id);
}
