package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.port.in.response.BookResponse;
import org.springframework.web.bind.annotation.PathVariable;

public interface FindBookUseCase {

    BookResponse getBook(@PathVariable String isbn);
}
