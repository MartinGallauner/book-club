package com.martingallauner.bookclub.assignments;

import lombok.Data;

@Data
public class AssignmentRequest {

    private Long userId;
    private String isbn;
}
