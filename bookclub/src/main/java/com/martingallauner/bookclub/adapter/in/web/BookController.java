package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.port.in.FindBookUseCase;
import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController implements FindBookUseCase {

    private final FindBookUseCase findBookUseCase;

    @Override
    @GetMapping("/{isbn}")
    public BookResponse getBook(@PathVariable String isbn) {
        return findBookUseCase.getBook(isbn);
    }
}
