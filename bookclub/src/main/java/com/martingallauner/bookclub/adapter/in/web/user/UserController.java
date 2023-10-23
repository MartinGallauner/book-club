package com.martingallauner.bookclub.adapter.in.web.user;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.AddConnectionUseCase;
import com.martingallauner.bookclub.application.port.in.CreateUserUseCase;
import com.martingallauner.bookclub.application.port.in.GetUserUseCase;
import com.martingallauner.bookclub.application.port.in.request.ConnectUserRequest;
import com.martingallauner.bookclub.application.port.in.request.CreateUserRequest;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final AddConnectionUseCase addConnectionUseCase;


    @Operation(summary = "Get user by id")
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        UserModel userEntity = getUserUseCase.getUserById(id);
        return userEntity.toResponse();
    }

    @Operation(summary = "Create user")
    @PostMapping
    public UserResponse createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        UserModel user = createUserUseCase.createUser(createUserRequest);
        return user.toResponse();
    }

    @Operation(summary = "Connect users")
    @PostMapping("/connect")
    public void connectUser(@RequestBody ConnectUserRequest connectUserRequest) {
        addConnectionUseCase.addConnection(connectUserRequest);
    }
}
