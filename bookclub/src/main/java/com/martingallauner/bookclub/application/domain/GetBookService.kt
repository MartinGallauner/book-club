package com.martingallauner.bookclub.application.domain

import com.martingallauner.bookclub.adapter.out.client.OpenLibraryClient
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity
import com.martingallauner.bookclub.application.domain.model.BookModel
import com.martingallauner.bookclub.application.port.`in`.GetBookUseCase
import com.martingallauner.bookclub.application.port.out.BookRepository
import org.springframework.stereotype.Service

@Service
class GetBookService(private val bookRepository: BookRepository, private val openLibraryClient: OpenLibraryClient) :
    GetBookUseCase {

    override fun getBook(isbn: String): BookModel {
        val book = bookRepository.findById(isbn).orElseGet { fetchAndSave(isbn) }
        return book.toModel();
    }

    private fun fetchAndSave(isbn: String): BookEntity {
        val bookEntity = openLibraryClient.fetchMetadataForBook(isbn);
        bookRepository.save(bookEntity);
        return bookEntity;
    }
}
