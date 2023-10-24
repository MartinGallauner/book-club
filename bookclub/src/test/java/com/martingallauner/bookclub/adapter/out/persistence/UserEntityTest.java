package com.martingallauner.bookclub.adapter.out.persistence;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

class UserEntityTest {

    @Test
    void toModel() {
        BookEntity book = BookEntity.builder()
                .isbn("1234")
                .author("author")
                .title("title")
                .description("description")
                .pages(123L)
                .build();

        UserEntity userEntity = UserEntity.builder()
                .id(55L)
                .password("password")
                .createdAt(LocalDateTime.MIN)
                .books(List.of(book))
                .build();

        UserModel user = userEntity.toModel();

        assertThat(user.getId()).isEqualTo(55L);
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getCreatedAt()).isEqualTo(LocalDateTime.MIN);
        assertThat(user.getBooks()).hasSize(1);
    }
}
