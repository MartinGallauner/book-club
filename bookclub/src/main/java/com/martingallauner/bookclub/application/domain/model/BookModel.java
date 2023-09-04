package com.martingallauner.bookclub.application.domain.model;

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

}
