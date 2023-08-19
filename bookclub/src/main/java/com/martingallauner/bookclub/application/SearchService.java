package com.martingallauner.bookclub.application;

import com.martingallauner.bookclub.adapter.out.persistence.Book;
import com.martingallauner.bookclub.application.domain.BookService;
import com.martingallauner.bookclub.adapter.out.persistence.User;
import com.martingallauner.bookclub.application.port.in.SearchBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchService implements SearchBookUseCase {

    private final BookService bookService;

    @Override
    public Set<User> searchBooks(String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        return book.getUsers();
    }
}
