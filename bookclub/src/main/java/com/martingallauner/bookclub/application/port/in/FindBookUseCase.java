package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.book.Book;
import org.springframework.web.bind.annotation.PathVariable;

public interface FindBookUseCase {

    Book findBook(@PathVariable String isbn);
}
