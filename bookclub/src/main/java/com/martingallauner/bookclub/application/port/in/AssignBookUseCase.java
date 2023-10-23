package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;

public interface AssignBookUseCase {

    boolean assign(AssignmentRequest assignment);

}
