package com.martingallauner.bookclub.application.domain.search;

import com.martingallauner.bookclub.application.domain.book.Book;
import com.martingallauner.bookclub.application.domain.book.BookService;
import com.martingallauner.bookclub.application.domain.user.User;
import com.martingallauner.bookclub.application.port.in.SearchBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
