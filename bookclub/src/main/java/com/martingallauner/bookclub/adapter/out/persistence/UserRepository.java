package com.martingallauner.bookclub.adapter.out.persistence;

import com.martingallauner.bookclub.application.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
