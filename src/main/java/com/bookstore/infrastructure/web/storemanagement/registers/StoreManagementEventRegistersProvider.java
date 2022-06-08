package com.bookstore.infrastructure.web.storemanagement.registers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.application.shared.EventEmitter;
import com.bookstore.infrastructure.web.shared.EventRegister;
import com.bookstore.infrastructure.web.shared.EventRegistersProvider;

public class StoreManagementEventRegistersProvider implements EventRegistersProvider {
    private List<EventRegister> eventRegisters;
    private EventEmitter eventEmitter;

    @Autowired
    public StoreManagementEventRegistersProvider(SaveBookRegisterEvent saveBookRegisterEvent,
            EventEmitter eventEmitter) {
        this.eventRegisters = new ArrayList<>();
        this.eventRegisters.add(saveBookRegisterEvent);
        this.eventEmitter = eventEmitter;
    }

    @Override
    public void registerEvents() {
        this.eventRegisters.forEach(eventRegister -> eventRegister.register(this.eventEmitter));

    }

}
