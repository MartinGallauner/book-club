package com.martingallauner.bookclub.application.domain.assignments;

import com.martingallauner.bookclub.application.domain.book.Book;
import com.martingallauner.bookclub.application.domain.book.BookService;
import com.martingallauner.bookclub.application.domain.user.User;
import com.martingallauner.bookclub.application.domain.user.UserService;
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
        Book book = bookService.getBookByIsbn(isbn);
        userService.addBook(userId, book);
    }

    @Override
    public AssignedBooksResponse getBooksByUserId(Long userId) {
        User user = userService.getUserById(userId);

        return AssignedBooksResponse.builder()
                .user(user.toResponse())
                .books(user.getBooks())
                .build();
    }
}
