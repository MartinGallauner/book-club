package com.martingallauner.bookclub.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.martingallauner.bookclub.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Table(name = "books")
@Entity
@Getter
@Setter
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
