package com.bookstore.infrastructure.email;

import org.springframework.stereotype.Service;

import com.bookstore.adapters.services.email.IEmailService;
import com.bookstore.adapters.services.email.entity.Email;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailService implements IEmailService {

    @Override
    public void send(Email email) {
        log.info("Sending email: {}", email);

    }

}
