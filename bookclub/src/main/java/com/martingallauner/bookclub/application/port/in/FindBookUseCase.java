package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.adapter.out.persistence.Book;
import org.springframework.web.bind.annotation.PathVariable;

public interface FindBookUseCase {

    Book getBook(@PathVariable String isbn);
}
