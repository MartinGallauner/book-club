package com.martingallauner.bookclub.application;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeService {

    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }
}
