package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.user.ConnectUserRequest;

public interface AddConnectionUseCase {

    void addConnection(ConnectUserRequest request);

}
