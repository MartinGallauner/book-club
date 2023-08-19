package com.martingallauner.bookclub.application.port.in;


import com.martingallauner.bookclub.application.domain.user.User;

import java.util.Set;

/**
 * Searches for users who have the specified book.
 */
public interface SearchBookUseCase {

    Set<User> searchBooks(String isbn);
}
