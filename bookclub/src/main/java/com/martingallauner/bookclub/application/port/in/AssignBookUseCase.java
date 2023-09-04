package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.adapter.in.web.AssignedBooksResponse;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;

public interface AssignBookUseCase {

    void assign(AssignmentRequest assignment);

    AssignedBooksResponse getBooksByUserId(Long userId);
}
