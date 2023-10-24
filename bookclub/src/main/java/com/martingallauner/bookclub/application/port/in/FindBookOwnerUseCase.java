package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.model.UserModel;

import java.util.Set;

public interface FindBookOwnerUseCase {

    Set<UserModel> findBookOwner(String isbn);
}
