package com.martingallauner.bookclub.adapter.out.persistence;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.google.common.truth.Truth.assertThat;


class BookEntityTest {

    @DisplayName("Tests mapping from BookEntity to BookModel.")
    @Test
    void toModel() {
        BookEntity entity = BookEntity.builder()
                .isbn("1111-2222")
                .title("test title")
                .author("test author")
                .genre("testing")
                .description("a stupid book about testing.")
                .publisher("noone")
                .pages(666L)
                .owners(Set.of(UserEntity.builder().build()))
                .build();

        BookModel model = entity.toModel();
        assertThat(model.getIsbn()).isEqualTo("1111-2222");
        assertThat(model.getTitle()).isEqualTo("test title");
        assertThat(model.getAuthor()).isEqualTo("test author");
        assertThat(model.getGenre()).isEqualTo("testing");
        assertThat(model.getDescription()).isEqualTo("a stupid book about testing.");
        assertThat(model.getPublisher()).isEqualTo("noone");
        assertThat(model.getPages()).isEqualTo(666L);}
}
