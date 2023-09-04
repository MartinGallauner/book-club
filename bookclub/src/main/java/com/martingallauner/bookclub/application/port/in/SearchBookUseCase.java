package com.martingallauner.bookclub.application.port.in;


import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;

import java.util.Set;

/**
 * Searches for users who have the specified book.
 */
public interface SearchBookUseCase {

    Set<UserEntity> searchBooks(String isbn);
}
