package com.martingallauner.bookclub.application.port.out;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;

public interface FetchOpenLibraryPort {

    BookEntity fetchMetadataForBook(String isbn);
}
