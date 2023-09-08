package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class AssignedBooksResponse {

    private UserResponse user;
    private Set<BookResponse> books;
}
