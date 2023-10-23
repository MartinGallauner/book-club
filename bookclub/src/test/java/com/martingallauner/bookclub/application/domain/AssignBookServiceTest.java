package com.martingallauner.bookclub.application.domain;

import com.google.common.truth.Truth;
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssignBookServiceTest {

    @InjectMocks
    private AssignBookService assignBookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserRepository userRepository;

    @DisplayName("Assign book to user")
    @Test
    void assign() {
        //given
        BookEntity book = BookEntity.builder().isbn("1234").title("test book").build();
        UserEntity user = UserEntity.builder().id(5L).name("test user").books(new ArrayList<>()).build();

        when(userRepository.getReferenceById(5L)).thenReturn(user);
        when(bookRepository.getReferenceById("1234")).thenReturn(book);
        when(userRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        //when
        boolean result = assignBookService.assign(new AssignmentRequest(5L, "1234"));

        //then
        Truth.assertThat(result).isTrue();
    }
}
