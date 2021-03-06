package com.bookstore.application.bookcatalogs.handlers;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.adapters.services.email.IEmailService;
import com.bookstore.adapters.services.email.entity.Email;
import com.bookstore.application.shared.DataEvent;
import com.bookstore.application.shared.Event;
import com.bookstore.application.shared.Handler;
import com.bookstore.application.storemanagement.dto.BookSavedData;

public class SendEmailToTeamNewBookEventHandler implements Handler {

    private IEmailService emailService;

    public SendEmailToTeamNewBookEventHandler(IEmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void handle(Event<? extends DataEvent> event) {
        // TODO get teams email address from configuration
        // TODO get email text from configuration
        if (event.getEventData() instanceof BookSavedData) {
            BookSavedData eventData = (BookSavedData) event.getEventData();
            String from = "storageteam@bookstore.com";
            String to = "sellerteam@bookstore.com";
            String subject = "New Book saved";
            List<String> atachments = new ArrayList<>();
            String message = "New Book Created: " + eventData.book().toString();
            Email email = new Email(to, from, message, subject, atachments);

            this.emailService.send(email);
        }

    }

}
