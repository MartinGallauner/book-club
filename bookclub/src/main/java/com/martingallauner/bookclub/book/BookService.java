package com.martingallauner.bookclub.book;

import com.martingallauner.bookclub.book.client.OpenLibraryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    private final OpenLibraryClient openLibraryClient;


    public Book getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElse(fetchAndSave(isbn));
    }

    private Book fetchAndSave(String isbn) {
        Book book = openLibraryClient.fetchMetadataForBook(isbn);
        return bookRepository.save(book);
    }

}
