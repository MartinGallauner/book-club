package com.martingallauner.bookclub;

import com.martingallauner.bookclub.adapter.out.persistence.BookEntity;
import com.martingallauner.bookclub.adapter.out.persistence.UserEntity;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, BookRepository bookRepository) {
        return args -> {

            BookEntity book1 = new BookEntity("ISBN1", "Book Eins", "Author Eins", "genre", "description", "publisher", 42L, null);
            BookEntity book2 = new BookEntity("ISBN2", "Book Zwei", "Author Zwei", "genre2", "description2", "publisher2", 442L, null);

            bookRepository.save(book1);
            bookRepository.save(book2);

            UserEntity user1 = new UserEntity(1L, "User Eins", "password", LocalDateTime.now(), List.of(book1), null);
            UserEntity user2 = new UserEntity(2L, "User Zwei", "geheimnis", LocalDateTime.now(), List.of(book2), null);
            userRepository.save(user1);
            userRepository.save(user2);
        };
    }
}
