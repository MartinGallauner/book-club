package com.martingallauner.bookclub.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "books")
@Entity
@Getter
@Setter
public class Book {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    private String author;

    private String genre;

    private String description;

    private String publisher;

    private Long pages;

}
