package com.martingallauner.bookclub.adapter.in.web.assigned;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.port.in.AssignBookUseCase;
import com.martingallauner.bookclub.application.port.in.GetAssignedBooksUseCase;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignBookUseCase assignBookUseCase;

    private final GetAssignedBooksUseCase getAssignedBooksUseCase;

    @PostMapping("/assign")
    public void assign(@RequestBody AssignmentRequest assignment) {
        assignBookUseCase.assign(assignment);
    }

    @GetMapping("/user/{userId}")
    public AssignedBooksResponse getBooksByUserId(@PathVariable Long userId) {
        List<BookModel> assignedBooks = getAssignedBooksUseCase.getAssignedBooks(userId);
        return new AssignedBooksResponse(userId, assignedBooks.stream().map(b -> b.toResponse()).toList());
    }
}