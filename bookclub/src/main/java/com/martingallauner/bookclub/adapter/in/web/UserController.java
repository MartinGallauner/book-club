package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.AddConnectionUseCase;
import com.martingallauner.bookclub.application.port.in.CreateUserUseCase;
import com.martingallauner.bookclub.application.port.in.GetUserUseCase;
import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final AddConnectionUseCase addConnectionUseCase;


    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        UserModel userEntity = getUserUseCase.getUserById(id);
        return userEntity.toResponse();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        UserModel user = createUserUseCase.createUser(createUserRequest);
        return user.toResponse();
    }

    @PostMapping("/connect")
    public void connectUser(@RequestBody ConnectUserRequest connectUserRequest) {
        addConnectionUseCase.addConnection(connectUserRequest);
    }
}
