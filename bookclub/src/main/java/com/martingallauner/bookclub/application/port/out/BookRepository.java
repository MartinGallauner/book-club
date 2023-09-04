package com.martingallauner.bookclub.application.port.out;

import com.martingallauner.bookclub.adapter.out.persistence.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
