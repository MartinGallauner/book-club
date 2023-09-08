package com.martingallauner.bookclub.application.port.in;


import com.martingallauner.bookclub.application.domain.model.UserModel;

import java.util.Set;

/**
 * Searches for connected user who have the specified book.
 */
public interface SearchBookInNetworkUseCase {

    Set<UserModel> searchBooks(String isbn);
}
