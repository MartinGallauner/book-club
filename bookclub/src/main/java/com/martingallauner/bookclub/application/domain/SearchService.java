package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.in.SearchBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchService implements SearchBookUseCase {

    private final BookService bookService;

    @Override
    public Set<UserEntity> searchBooks(String isbn) {
        BookEntity book = bookService.getBookByIsbn(isbn);
        return book.getUsers();
    }
}
