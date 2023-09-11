package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.model.BookModel;

import java.util.List;

public interface GetAssignedBooksUseCase {

    List<BookModel> getAssignedBooks(Long userId);

}
