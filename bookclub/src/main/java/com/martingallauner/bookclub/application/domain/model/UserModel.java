package com.martingallauner.bookclub.application.domain.model;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class UserModel {

    private Long id;

    private String name;

    private String password;

    private LocalDateTime createdAt;

    private Set<BookEntity> books;

    private Set<UserEntity> connections;

}
