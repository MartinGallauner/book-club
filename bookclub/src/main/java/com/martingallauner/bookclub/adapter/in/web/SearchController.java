package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.SearchBookInNetworkUseCase;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchBookInNetworkUseCase searchBookUseCase;


    @GetMapping("/{isbn}")
    public List<UserResponse> searchBooks(@PathVariable String isbn) {
        Set<UserModel> users = searchBookUseCase.searchBooks(isbn);
        return users.stream()
                .map(UserModel::toResponse)
                .toList();
    }
}
