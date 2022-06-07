package com.bookstore.application.shared;

public interface Handler {
    public void handle(Event<? extends DataEvent> event);
}
