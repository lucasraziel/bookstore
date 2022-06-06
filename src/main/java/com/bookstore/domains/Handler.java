package com.bookstore.domains;

public interface Handler {
    public void handle(Event<? extends DataEvent> event);
}
