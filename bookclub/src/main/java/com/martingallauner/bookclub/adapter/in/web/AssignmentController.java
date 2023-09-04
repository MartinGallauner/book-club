package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.port.in.AssignBookUseCase;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignBookUseCase assignBookUseCase;

    @PostMapping("/assign")
    public void assign(@RequestBody AssignmentRequest assignment) {
        assignBookUseCase.assign(assignment);
    }

    @GetMapping("/user/{userId}")
    public AssignedBooksResponse getBooksByUserId(@PathVariable Long userId) {
        return assignBookUseCase.getBooksByUserId(userId);
    }
}
