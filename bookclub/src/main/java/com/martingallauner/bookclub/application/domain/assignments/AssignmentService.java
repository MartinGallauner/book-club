package com.martingallauner.bookclub.application.domain.assignments;

import com.martingallauner.bookclub.application.domain.book.Book;
import com.martingallauner.bookclub.application.domain.book.BookService;
import com.martingallauner.bookclub.application.domain.user.User;
import com.martingallauner.bookclub.application.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AssignmentService {

    private final BookService bookService;
    private final UserService userService;


    public void assign(Long userId, String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        userService.addBook(userId, book);
    }

    public AssignedBooksResponse getBooksByUserId(Long userId) {
        User user = userService.getUserById(userId);

        return AssignedBooksResponse.builder()
                .user(user.toResponse())
                .books(user.getBooks())
                .build();
    }
}
