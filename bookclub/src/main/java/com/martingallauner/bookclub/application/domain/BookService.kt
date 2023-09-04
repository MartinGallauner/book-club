package com.martingallauner.bookclub.application.domain

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity
import com.martingallauner.bookclub.application.port.out.BookRepository
import com.martingallauner.bookclub.adapter.out.persistence.client.OpenLibraryClient
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository, private val openLibraryClient: OpenLibraryClient) {

    fun getBookByIsbn(isbn: String): BookEntity {
        return bookRepository.findById(isbn).orElseGet { fetchAndSave(isbn) }
    }

    private fun fetchAndSave(isbn: String): BookEntity {
        val book = openLibraryClient.fetchMetadataForBook(isbn);
        return bookRepository.save(book);
    }
}
