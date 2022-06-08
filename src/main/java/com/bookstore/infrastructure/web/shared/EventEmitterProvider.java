package com.bookstore.infrastructure.web.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bookstore.application.shared.EventEmitter;
import com.bookstore.infrastructure.web.storemanagement.registers.SaveBookRegisterEvent;
import com.bookstore.infrastructure.web.storemanagement.registers.StoreManagementEventRegistersProvider;

import lombok.Getter;

@Service
@Scope("singleton")
@Getter
public class EventEmitterProvider {
    private EventEmitter eventEmitter;

    @Autowired
    public EventEmitterProvider(SaveBookRegisterEvent saveBookRegisterEvent) {
        this.eventEmitter = new EventEmitter();
        EventRegistersProvider storeManagementEventRegistersProvider = new StoreManagementEventRegistersProvider(
                saveBookRegisterEvent,
                this.eventEmitter);
        storeManagementEventRegistersProvider.registerEvents();
    }

}
