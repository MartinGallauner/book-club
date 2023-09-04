package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;

public interface AddConnectionUseCase {

    void addConnection(ConnectUserRequest request);

}
