package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.FindBookOwnerUseCase;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FindBookOwnerService implements FindBookOwnerUseCase {

    private final BookRepository bookRepository;

    @Override
    public Set<UserModel> findBookOwner(String isbn) {
        Optional<BookEntity> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isEmpty()) {
            return new HashSet<>();
        }

        return bookOptional.get().getOwners().stream()
                .map(UserEntity::toModel)
                .collect(Collectors.toSet());

    }
}
