package com.martingallauner.bookclub.application.domain.assignments;

import lombok.Data;

@Data
public class AssignmentRequest {

    private Long userId;
    private String isbn;
}
