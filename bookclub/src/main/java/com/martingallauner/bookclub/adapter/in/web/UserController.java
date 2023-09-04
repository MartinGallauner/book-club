package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
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
        UserEntity user = getUserUseCase.getUserById(id);
        return user.toResponse();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        UserEntity user = createUserUseCase.createUser(createUserRequest);
        return new UserResponse(user.getId(), user.getName(), user.getCreatedAt().toString(), null);
    }

    @PostMapping("/connect")
    public void connectUser(@RequestBody ConnectUserRequest connectUserRequest) {
        addConnectionUseCase.addConnection(connectUserRequest);
    }
}
