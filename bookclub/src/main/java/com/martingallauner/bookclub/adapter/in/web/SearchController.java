package com.martingallauner.bookclub.adapter.in.web;

import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.FindBookOwnerUseCase;
import com.martingallauner.bookclub.application.port.in.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final FindBookOwnerUseCase findBookOwnerUseCase;

    @Operation(summary = "Search for a book in the network")
    @GetMapping("/{isbn}")
    public List<UserResponse> searchBooks(@PathVariable String isbn) {
        Set<UserModel> users = findBookOwnerUseCase.findBookOwner(isbn);
        return users.stream()
                .map(UserModel::toResponse)
                .toList();
    }
}
