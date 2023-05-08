package com.martingallauner.bookclub.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new UserDto(user.getId(),
                user.getName(),
                user.getPassword(),
                user.getCreatedAt().toString());
    }

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);
        return new UserDto(user.getId(),
                user.getName(),
                user.getPassword(),
                user.getCreatedAt().toString());
    }
}
