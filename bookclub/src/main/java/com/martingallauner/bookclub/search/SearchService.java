package com.martingallauner.bookclub.search;

import com.martingallauner.bookclub.book.Book;
import com.martingallauner.bookclub.book.BookService;
import com.martingallauner.bookclub.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final BookService bookService;

    public Set<User> searchBooks(String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        return book.getUsers();
    }
}
