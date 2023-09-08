package com.martingallauner.bookclub.application.domain.model;

import com.google.common.truth.Truth;
import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.*;
import static org.junit.jupiter.api.Assertions.*;

class BookModelTest {

    @DisplayName("Tests the mapping from Book to Response.")
    @Test
    void toResponse() {
        BookModel bookModel = BookModel.builder()
                .isbn("1111-Mock")
                .title("test-Title")
                .author("test-Author")
                .genre("test-Genre")
                .description("test-Description")
                .publisher("test-Publisher")
                .pages(42L)
                .build();

        BookResponse response = bookModel.toResponse();

        assertThat(response.isbn()).isEqualTo("1111-Mock");
        assertThat(response.title()).isEqualTo("test-Title");
        assertThat(response.author()).isEqualTo("test-Author");
        assertThat(response.genre()).isEqualTo("test-Genre");
        assertThat(response.description()).isEqualTo("test-Description");
        assertThat(response.publisher()).isEqualTo("test-Publisher");
        assertThat(response.pages()).isEqualTo(42L);
    }
}
