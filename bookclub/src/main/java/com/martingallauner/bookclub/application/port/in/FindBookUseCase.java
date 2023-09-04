package com.martingallauner.bookclub.application.port.in;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface FindBookUseCase {

    BookEntity getBook(@PathVariable String isbn);
}
