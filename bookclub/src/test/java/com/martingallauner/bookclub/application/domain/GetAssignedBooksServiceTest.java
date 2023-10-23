package com.martingallauner.bookclub.application.domain;

import com.google.common.truth.Truth;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAssignedBooksServiceTest {

    @InjectMocks
    private GetAssignedBooksService getAssignedBooksService;

    @Mock
    private GetUserService userService;

    @DisplayName("Get books of user.")
    @Test
    void getAssignedBooks() {
        BookModel book1 = BookModel.builder().isbn("1234567890").title("Test Book").build();
        BookModel book2 = BookModel.builder().isbn("987654321").title("Mock Book").build();
        UserModel user = UserModel.builder().id(1L).books(List.of(book1, book2)).build();

        when(userService.getUserById(1L)).thenReturn(user);

        List<BookModel> assignedBooks = getAssignedBooksService.getAssignedBooks(1L);

        assertThat(assignedBooks).containsExactly(book1, book2);
    }
}
