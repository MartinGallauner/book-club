package com.martingallauner.bookclub.application.port.in;


import com.martingallauner.bookclub.application.domain.model.UserModel;

public interface GetUserUseCase {

    UserModel getUserById(Long id);
}
