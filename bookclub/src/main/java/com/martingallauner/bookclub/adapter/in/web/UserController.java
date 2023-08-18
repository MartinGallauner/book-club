package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.domain.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user.toResponse();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);
        return new UserResponse(user.getId(), user.getName(), user.getCreatedAt().toString(), null);
    }

    @PostMapping("/connect")
    public void createUser(@RequestBody ConnectUserRequest connectUserRequest) {
        userService.addConnection(connectUserRequest);
    }
}
