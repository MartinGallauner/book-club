package com.martingallauner.bookclub.adapter.out.persistence;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "books")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {

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
    private Set<UserEntity> users;

    public BookModel toModel() {
        return BookModel.builder()
                .isbn(getIsbn())
                .title(getTitle())
                .author(getAuthor())
                .genre(getGenre())
                .pages(getPages())
                .description(getDescription())
                .publisher(getPublisher())
                .build();
    }
}
