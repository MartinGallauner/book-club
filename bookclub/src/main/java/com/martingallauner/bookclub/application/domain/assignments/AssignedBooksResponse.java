package com.martingallauner.bookclub.application.domain.assignments;

import com.martingallauner.bookclub.application.domain.book.Book;
import com.martingallauner.bookclub.application.domain.user.UserResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class AssignedBooksResponse {

    private UserResponse user;
    private Set<Book> books;
}
