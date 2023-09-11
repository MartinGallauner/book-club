package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.GetAssignedBooksUseCase;
import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAssignedBooksService implements GetAssignedBooksUseCase {

    private final GetUserService userService;

    @Override
    public List<BookModel> getAssignedBooks(Long userId) {
        UserModel user = userService.getUserById(userId);
        return user.getBooks();
    }
}
