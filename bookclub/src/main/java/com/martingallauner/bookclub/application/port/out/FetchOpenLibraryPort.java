package com.martingallauner.bookclub.application.port.out;

import com.martingallauner.bookclub.adapter.out.persistence.Book;

public interface FetchOpenLibraryPort {

    Book fetchMetadataForBook(String isbn);
}
