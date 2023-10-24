package com.martingallauner.bookclub.adapter.in.web.assignment;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.port.in.AssignBookUseCase;
import com.martingallauner.bookclub.application.port.in.GetAssignedBooksUseCase;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignBookUseCase assignBookUseCase;

    private final GetAssignedBooksUseCase getAssignedBooksUseCase;

    @Operation(summary = "Assign a book to a user")
    @PostMapping("/assign")
    public void assignBookToUser(@RequestBody AssignmentRequest assignment) {
        assignBookUseCase.assign(assignment);
    }

    @Operation(summary = "Get all books assigned to a user")
    @GetMapping("/user/{userId}")
    public AssignedBooksResponse getBooksByUserId(@PathVariable Long userId) {
        List<BookModel> assignedBooks = getAssignedBooksUseCase.getAssignedBooks(userId);
        return new AssignedBooksResponse(userId, assignedBooks.stream().map(BookModel::toResponse).toList());
    }
}
