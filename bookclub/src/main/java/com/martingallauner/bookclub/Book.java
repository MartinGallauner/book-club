package com.martingallauner.bookclub;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Book {

    @JsonIgnore
    private Long id;

    private String title;

    private String isbn;

    private String author;

    private String genre;

    private String description;

    private String publisher;

    private Long pages;

}
