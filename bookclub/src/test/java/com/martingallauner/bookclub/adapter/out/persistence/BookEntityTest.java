package com.martingallauner.bookclub.adapter.out.persistence;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;



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
                .build();

        BookModel model = entity.toModel();
        assertThat(model.getIsbn()).matches("1111-2222");
        assertThat(model.getTitle().matches("test title"));
        assertThat(model.getAuthor().matches("test author"));
        assertThat(model.getGenre().matches("testing"));
        assertThat(model.getDescription().matches("a stupid book about testing."));
        assertThat(model.getPublisher().matches("noone"));
        assertThat(model.getPages().equals(666L));
    }
}
