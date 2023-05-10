package com.martingallauner.bookclub.book;

import com.martingallauner.bookclub.book.client.OpenLibraryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final OpenLibraryClient openLibraryClient;

    private final BookService bookService;

    @GetMapping("/{isbn}")
    public Book fetchBook(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);

    }
}
