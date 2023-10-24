package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.FindBookOwnerUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Set;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@WebMvcTest(SearchController.class)
class SearchControllerTest {

    @MockBean
    private FindBookOwnerUseCase findBookOwnerUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchBooks() throws Exception {

        when(findBookOwnerUseCase.findBookOwner("1234567890")).thenReturn(Set.of(UserModel.builder().id(5L).name("Book Owner").createdAt(LocalDateTime.parse("2023-10-24T12:05:00")).build()));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/search/{isbn}", "1234567890")
                        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].createdAt", notNullValue()))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
