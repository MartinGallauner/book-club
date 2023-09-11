package com.martingallauner.bookclub.application.domain;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.in.AssignBookUseCase;
import com.martingallauner.bookclub.application.port.in.request.AssignmentRequest;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AssignBookService implements AssignBookUseCase {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public void assign(AssignmentRequest request) {
        BookEntity book = bookRepository.getReferenceById(request.isbn());
        UserEntity user = userRepository.getReferenceById(request.userId());
        user.getBooks().add(book);
        userRepository.save(user);
    }


}
