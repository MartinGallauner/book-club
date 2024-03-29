package com.martingallauner.bookclub.application.domain.model;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class UserModel {

    private Long id;

    private String name;

    private String password;

    private LocalDateTime createdAt;

    @Builder.Default
    private List<BookModel> books = new ArrayList<>();

    @Builder.Default
    private List<UserModel> connections  = new ArrayList<>();



    public UserResponse toResponse() {
        /*
        Set<Long> friendIds = this.getConnections().stream()
                .map(UserModel::getId)
                .collect(Collectors.toSet());

         */
        //todo implement
        return new UserResponse(this.getId(), this.getName(), this.getCreatedAt().toString());
    }
}
