package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.domain.assignments.AssignedBooksResponse;
import com.martingallauner.bookclub.application.domain.assignments.AssignmentRequest;
import com.martingallauner.bookclub.application.domain.assignments.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping("/assign")
    public void assign(@RequestBody AssignmentRequest assignment) {
        assignmentService.assign(assignment.getUserId(), assignment.getIsbn());
    }

    @GetMapping("/user/{userId}")
    public AssignedBooksResponse getBooksByUserId(@PathVariable Long userId) {
        return assignmentService.getBooksByUserId(userId);
    }
}
