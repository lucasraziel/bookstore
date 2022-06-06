package com.bookstore.domains.book.events.booksaved.handlers;

import com.bookstore.domains.DataEvent;
import com.bookstore.domains.Event;
import com.bookstore.domains.Handler;
import com.bookstore.domains.book.BookRepository;
import com.bookstore.domains.book.events.booksaved.dto.BookSavedData;

public class SaveBookToRepository implements Handler {
    private final BookRepository bookRepository;

    public SaveBookToRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void handle(Event<? extends DataEvent> event) {
        if (event.eventData instanceof BookSavedData) {
            BookSavedData eventData = (BookSavedData) event.eventData;
            this.bookRepository.save(eventData.book());
        }

    }
}
