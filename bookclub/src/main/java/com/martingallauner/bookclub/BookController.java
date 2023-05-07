package com.martingallauner.bookclub;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final OpenLibraryClient openLibraryClient;

    @GetMapping("/api/books/{isbn}")
    public Book fetchBook(@PathVariable String isbn) {
        return openLibraryClient.fetchMetadataForBook(isbn);

    }
}
