package com.martingallauner.bookclub.application.port.in;


import com.martingallauner.bookclub.application.domain.user.User;

import java.util.Set;

public interface SearchBookUseCase {

    Set<User> searchBooks(String isbn);
}
