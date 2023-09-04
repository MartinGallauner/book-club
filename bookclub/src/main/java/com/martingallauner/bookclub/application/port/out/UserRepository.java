package com.martingallauner.bookclub.application.port.out;

import com.martingallauner.bookclub.adapter.out.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
