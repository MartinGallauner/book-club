package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.assignments.AssignedBooksResponse;

public interface AssignBookUseCase {

    void assign(Long userId, String isbn);

    AssignedBooksResponse getBooksByUserId(Long userId);
}
