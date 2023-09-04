package com.martingallauner.bookclub;

import com.martingallauner.bookclub.adapter.out.persistence.Book;
import com.martingallauner.bookclub.application.port.out.BookRepository;
import com.martingallauner.bookclub.adapter.out.persistence.User;
import com.martingallauner.bookclub.application.port.out.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, BookRepository bookRepository) {
        return args -> {

            Book book1 = new Book("ISBN1", "Book Eins", "Author Eins", "genre", "description", "publisher", 42L, null);
            Book book2 = new Book("ISBN2", "Book Zwei", "Author Zwei", "genre2", "description2", "publisher2", 442L, null);

            bookRepository.save(book1);
            bookRepository.save(book2);

            User user1 = new User(1L, "User Eins", "password", LocalDateTime.now(), Collections.singleton(book1), null);
            User user2 = new User(2L, "User Zwei", "geheimnis", LocalDateTime.now(), Collections.singleton(book2), Collections.singleton(user1));
            userRepository.save(user1);
            userRepository.save(user2);
        };
    }
}
