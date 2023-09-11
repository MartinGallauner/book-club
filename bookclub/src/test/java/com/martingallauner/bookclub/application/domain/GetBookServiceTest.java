package com.martingallauner.bookclub.application.domain;

import com.google.common.truth.Truth;
import com.martingallauner.bookclub.adapter.out.client.OpenLibraryClient;
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.google.common.truth.Truth.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetBookServiceTest {

    @InjectMocks
    private GetBookService getBookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private OpenLibraryClient openLibraryClient;

    @Captor
    ArgumentCaptor<BookEntity> bookCaptor;


    @DisplayName("Get book from database.")
    @Test
    void getBook() {
        //given
        BookEntity book = BookEntity.builder().isbn("978-1839211966").author("Tom Hombergs").pages(156L).title("Get Your Hands Dirty on Clean Architecture").build();
        when(bookRepository.findById("978-1839211966")).thenReturn(Optional.of(book));

        //when
        BookModel result = getBookService.getBook("978-1839211966");

        //then
        assertThat(result.getIsbn()).isEqualTo("978-1839211966");
        assertThat(result.getAuthor()).isEqualTo("Tom Hombergs");
        assertThat(result.getPages()).isEqualTo(156L);
        assertThat(result.getTitle()).isEqualTo("Get Your Hands Dirty on Clean Architecture");
    }

    @DisplayName("Tests if OpenLibraryClient is called when book isn't avail in database.")
    @Test
    void fetchBookFromOpenLibrary() {
        //given
        when(bookRepository.findById("978-1839211966")).thenReturn(Optional.empty());
        BookEntity book = BookEntity.builder().isbn("978-1839211966").author("Tom Hombergs").pages(156L).title("Get Your Hands Dirty on Clean Architecture").build();
        when(openLibraryClient.fetchMetadataForBook("978-1839211966")).thenReturn(book);
        when(bookRepository.save(book)).thenAnswer(i -> i.getArguments()[0]);

        //when
        BookModel result = getBookService.getBook("978-1839211966");

        //then
        verify(bookRepository, times(1)).findById("978-1839211966");
        verify(openLibraryClient, times(1)).fetchMetadataForBook("978-1839211966");

        verify(bookRepository).save(bookCaptor.capture());
        BookEntity savedBook = bookCaptor.getValue();
        assertThat(savedBook.getIsbn()).isEqualTo("978-1839211966");
        assertThat(savedBook.getAuthor()).isEqualTo("Tom Hombergs");
        assertThat(savedBook.getPages()).isEqualTo(156L);
        assertThat(savedBook.getTitle()).isEqualTo("Get Your Hands Dirty on Clean Architecture");
    }


    @DisplayName("Test if BookNotFoundException is thrown when book is not returned from OpenLibraryClient.")
    @Test
    void bookNotFoundInOpenLibrary() throws Exception {
        when(bookRepository.findById("978-1839211966")).thenReturn(Optional.empty());




    }
}
