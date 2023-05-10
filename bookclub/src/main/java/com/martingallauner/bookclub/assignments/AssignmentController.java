package com.martingallauner.bookclub.assignments;

import com.martingallauner.bookclub.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
