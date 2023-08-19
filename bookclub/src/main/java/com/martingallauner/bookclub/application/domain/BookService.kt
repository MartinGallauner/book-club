package com.martingallauner.bookclub.application.domain

import com.martingallauner.bookclub.adapter.out.persistence.Book
import com.martingallauner.bookclub.adapter.out.persistence.BookRepository
import com.martingallauner.bookclub.adapter.out.persistence.OpenLibraryClient
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository, private val openLibraryClient: OpenLibraryClient) {

    fun getBookByIsbn(isbn: String): Book {
        return bookRepository.findById(isbn).orElseGet { fetchAndSave(isbn) }
    }

    private fun fetchAndSave(isbn: String): Book {
        val book = openLibraryClient.fetchMetadataForBook(isbn);
        return bookRepository.save(book);
    }
}
