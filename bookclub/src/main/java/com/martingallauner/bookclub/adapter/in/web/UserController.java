package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.domain.user.ConnectUserRequest;
import com.martingallauner.bookclub.application.domain.user.User;
import com.martingallauner.bookclub.application.domain.user.UserResponse;
import com.martingallauner.bookclub.application.port.in.AddConnectionUseCase;
import com.martingallauner.bookclub.application.port.in.CreateUserRequest;
import com.martingallauner.bookclub.application.port.in.CreateUserUseCase;
import com.martingallauner.bookclub.application.port.in.GetUserUseCase;
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
        User user = getUserUseCase.getUserById(id);
        return user.toResponse();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = createUserUseCase.createUser(createUserRequest);
        return new UserResponse(user.getId(), user.getName(), user.getCreatedAt().toString(), null);
    }

    @PostMapping("/connect")
    public void createUser(@RequestBody ConnectUserRequest connectUserRequest) {
        addConnectionUseCase.addConnection(connectUserRequest);
    }
}
