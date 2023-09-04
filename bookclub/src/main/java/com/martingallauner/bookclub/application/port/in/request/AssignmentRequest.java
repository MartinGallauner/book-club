package com.martingallauner.bookclub.application.port.in.request;

import lombok.Data;

@Data
public class AssignmentRequest {

    private Long userId;
    private String isbn;
}
