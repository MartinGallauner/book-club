package com.martingallauner.bookclub.application.domain;

import com.google.common.truth.Truth;
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindBookOwnerServiceTest {

    @InjectMocks
    FindBookOwnerService findBookOwnerService;

    @Mock
    BookRepository bookRepository;

    @Test
    void findBookOwner() {
        UserEntity owner = UserEntity.builder()
                .name("owner")
                .password("passwort")
                .createdAt(LocalDateTime.parse("2023-10-24T12:05:00"))
                .build();

        BookEntity bookEntity = BookEntity.builder()
                .isbn("ISBN1")
                .title("test title")
                .author("test author")
                .genre("testing")
                .description("a stupid book about testing.")
                .publisher("noone")
                .pages(666L)
                .owners(Set.of(owner))
                .build();
        //given
        when(bookRepository.findById("ISBN1")).thenReturn(Optional.of(bookEntity));

        //when
        Set<UserModel> result = findBookOwnerService.findBookOwner("ISBN1");

        //then
        Truth.assertThat(result).hasSize(1);

    }
}
