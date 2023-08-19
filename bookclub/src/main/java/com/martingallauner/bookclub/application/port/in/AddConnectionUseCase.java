package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.adapter.in.web.ConnectUserRequest;

public interface AddConnectionUseCase {

    void addConnection(ConnectUserRequest request);

}
