package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.SearchBookInNetworkUseCase;
import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchBookInNetworkInNetworkService implements SearchBookInNetworkUseCase {

    private final GetBookService getBookService;

    @Override
    public Set<UserModel> searchBooks(String isbn) {
        //BookResponse book = getBookService.getBook(isbn);
        //todo implement
        return new HashSet<>();
    }
}
