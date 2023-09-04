package com.martingallauner.bookclub.application.port.in;


import com.martingallauner.bookclub.application.domain.model.UserModel;

import java.util.Set;

/**
 * Searches for users who have the specified book.
 */
public interface SearchBookUseCase {

    Set<UserModel> searchBooks(String isbn);
}
