package com.martingallauner.bookclub.adapter.out.persistence;

import com.martingallauner.bookclub.application.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
