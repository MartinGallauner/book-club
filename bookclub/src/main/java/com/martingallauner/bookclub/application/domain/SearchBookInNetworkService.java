package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.SearchBookInNetworkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchBookInNetworkService implements SearchBookInNetworkUseCase {

    private final GetBookService getBookService;

    @Override
    public Set<UserModel> searchBooks(String isbn) {
        BookModel book = getBookService.getBook(isbn);
        return new HashSet<>();
    }
}
