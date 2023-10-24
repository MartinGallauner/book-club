package com.martingallauner.bookclub.adapter.in.web.assignment;

import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AssignedBooksResponse {

    private Long userId;
    private List<BookResponse> books;
}
