package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.in.web.AssignedBooksResponse;
import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.domain.model.BookModel;
import com.martingallauner.bookclub.application.domain.model.UserModel;
import com.martingallauner.bookclub.application.port.in.AssignBookUseCase;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AssignmentService implements AssignBookUseCase {

    private final GetBookService getBookService;
    private final GetUserService getUserService;

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public void assign(AssignmentRequest request) {
        BookEntity book = bookRepository.getReferenceById(request.isbn());
        UserEntity user = userRepository.getReferenceById(request.userId());
        user.getBooks().add(book);
        userRepository.save(user);
    }

    @Override
    public AssignedBooksResponse getBooksByUserId(Long userId) {
        UserModel user = getUserService.getUserById(userId);

        return AssignedBooksResponse.builder()
                .user(user.toResponse())
                .books(user.getBooks().stream().map(BookModel::toResponse).collect(Collectors.toSet()))
                .build();
    }
}
