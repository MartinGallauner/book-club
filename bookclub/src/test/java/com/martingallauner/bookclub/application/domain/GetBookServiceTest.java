package com.martingallauner.bookclub.application.domain;

import com.google.common.truth.Truth;
import com.martingallauner.bookclub.adapter.out.client.OpenLibraryClient;
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetBookServiceTest {

    @InjectMocks
    private GetBookService getBookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private OpenLibraryClient OpenLibraryClient;


    @DisplayName("Get book from database.")
    @Test
    void getBook() {
        //given
        BookEntity book = BookEntity.builder().isbn("978-1839211966").author("Tom Hombergs").pages(156L).title("Get Your Hands Dirty on Clean Architecture").build();
        when(bookRepository.findById("978-1839211966")).thenReturn(Optional.of(book));

        //when
        BookModel result = getBookService.getBook("978-1839211966");

        //then
        Truth.assertThat(result.getIsbn()).isEqualTo("978-1839211966");
        Truth.assertThat(result.getAuthor()).isEqualTo("Tom Hombergs");
        Truth.assertThat(result.getPages()).isEqualTo(156L);
        Truth.assertThat(result.getTitle()).isEqualTo("Get Your Hands Dirty on Clean Architecture");
    }
}
