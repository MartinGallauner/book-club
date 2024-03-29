package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.port.in.GetBookUseCase;
import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final GetBookUseCase findBookUseCase;

    @Operation(summary = "Get book by isbn")
    @GetMapping("/{isbn}")
    public BookResponse getBook(@PathVariable String isbn) {
        return findBookUseCase.getBook(isbn).toResponse();
    }
}
