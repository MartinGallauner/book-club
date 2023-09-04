package com.martingallauner.bookclub.application.domain.model;

import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookModel {

    private String isbn;

    private String title;

    private String author;

    private String genre;

    private String description;

    private String publisher;

    private Long pages;

    public BookResponse toResponse() {
        return new BookResponse(isbn, title, author, genre, description, publisher, pages);
    }

}
