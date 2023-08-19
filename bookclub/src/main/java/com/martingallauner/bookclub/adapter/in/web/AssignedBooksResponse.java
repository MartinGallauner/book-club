package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.adapter.out.persistence.Book;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class AssignedBooksResponse {

    private UserResponse user;
    private Set<Book> books;
}
