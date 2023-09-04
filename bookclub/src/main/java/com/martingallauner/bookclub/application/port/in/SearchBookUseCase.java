package com.martingallauner.bookclub.application.port.in;


import com.martingallauner.bookclub.application.port.in.response.UserResponse;

import java.util.Set;

/**
 * Searches for users who have the specified book.
 */
public interface SearchBookUseCase {

    Set<UserResponse> searchBooks(String isbn);
}
