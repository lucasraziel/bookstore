package com.bookstore.infrastructure.web.storemanagement.registers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.application.bookcatalogs.handlers.SendEmailToTeamNewBookEventHandler;
import com.bookstore.application.shared.EventEmitter;
import com.bookstore.application.shared.Handler;
import com.bookstore.infrastructure.email.EmailService;
import com.bookstore.infrastructure.web.shared.EventRegister;

@Service
public class SaveBookRegisterEvent implements EventRegister {

    private String eventId;

    private List<Handler> handlers;

    @Autowired
    public SaveBookRegisterEvent(EmailService emailService) {
        this.eventId = "BookSaved";
        this.handlers = new ArrayList<>();
        Handler sendEmailToTeamNewBookEventHandler = new SendEmailToTeamNewBookEventHandler(emailService);
        this.handlers.add(sendEmailToTeamNewBookEventHandler);
    }

    @Override
    public void register(EventEmitter eventEmitter) {
        eventEmitter.register(this.eventId, this.handlers);
    }

}
