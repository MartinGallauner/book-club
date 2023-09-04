package com.martingallauner.bookclub.application.port.in.response;

public record BookResponse(
        String isbn,
        String title,
        String author,
        String genre,
        String description,
        String publisher,
        Long pages) {
}
