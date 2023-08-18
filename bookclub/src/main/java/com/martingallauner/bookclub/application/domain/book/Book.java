package com.martingallauner.bookclub.application.domain.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.martingallauner.bookclub.application.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "books")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private String isbn;

    private String title;

    private String author;

    private String genre;

    private String description;

    private String publisher;

    private Long pages;

    @JsonBackReference
    @ManyToMany(mappedBy = "books")
    private Set<User> users;

}
