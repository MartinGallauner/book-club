package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.in.web.AssignedBooksResponse;
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.in.AssignBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AssignmentService implements AssignBookUseCase {

    private final BookService bookService;
    private final UserService userService;

    @Override
    public void assign(Long userId, String isbn) {
        BookEntity book = bookService.getBookByIsbn(isbn);
        userService.addBook(userId, book);
    }

    @Override
    public AssignedBooksResponse getBooksByUserId(Long userId) {
        UserEntity user = userService.getUserById(userId);

        return AssignedBooksResponse.builder()
                .user(user.toResponse())
                .books(user.getBooks())
                .build();
    }
}
