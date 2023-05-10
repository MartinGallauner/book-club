package com.martingallauner.bookclub.assignments;

import com.martingallauner.bookclub.book.Book;
import com.martingallauner.bookclub.book.BookService;
import com.martingallauner.bookclub.user.User;
import com.martingallauner.bookclub.user.UserResponse;
import com.martingallauner.bookclub.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

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
                .user(new UserResponse(user.getId(), user.getName(), user.getCreatedAt().toString()))
                .books(user.getBooks())
                .build();
    }
}
