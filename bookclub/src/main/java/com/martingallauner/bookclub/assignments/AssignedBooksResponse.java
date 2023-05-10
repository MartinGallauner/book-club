package com.martingallauner.bookclub.assignments;

import com.martingallauner.bookclub.book.Book;
import com.martingallauner.bookclub.user.User;
import com.martingallauner.bookclub.user.UserResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class AssignedBooksResponse {

    private UserResponse user;
    private Set<Book> books;
}
