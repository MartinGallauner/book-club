package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.SearchBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService implements SearchBookUseCase {

    private final BookService bookService;

    @Override
    public Set<UserModel> searchBooks(String isbn) {
        BookModel book = bookService.getBookByIsbn(isbn);

        return new HashSet<UserModel>();
    }
}
