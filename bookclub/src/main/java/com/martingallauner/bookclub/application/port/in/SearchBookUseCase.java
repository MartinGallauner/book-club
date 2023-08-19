package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.user.UserResponse;

import java.util.List;

public interface SearchBookUseCase {

    List<UserResponse> searchBooks(String isbn);
}
