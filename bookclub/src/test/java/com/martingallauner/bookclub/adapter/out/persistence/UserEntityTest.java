package com.martingallauner.bookclub.adapter.out.persistence;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void toModel() {
        UserEntity userEntity = UserEntity.builder()
                .id(55L)
                .password("password")
                .createdAt(LocalDateTime.now())
                .build();

        UserModel user = userEntity.toModel();

        assertThat(user.getPassword()).isEqualTo("password");
    }
}
