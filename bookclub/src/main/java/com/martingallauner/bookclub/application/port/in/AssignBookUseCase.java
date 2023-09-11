package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;

import java.util.List;

public interface AssignBookUseCase {

    void assign(AssignmentRequest assignment);

}
