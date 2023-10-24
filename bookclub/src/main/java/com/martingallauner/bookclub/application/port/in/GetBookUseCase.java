package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.application.domain.model.BookModel;
import org.springframework.web.bind.annotation.PathVariable;

public interface GetBookUseCase {

    BookModel getBook(@PathVariable String isbn);
}
