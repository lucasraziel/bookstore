package com.bookstore.domains.book.usecases.save;

import java.util.List;

import com.bookstore.domains.EventEmitter;
import com.bookstore.domains.book.entities.Book;
import com.bookstore.domains.book.events.booksaved.BookSaved;
import com.bookstore.domains.book.usecases.validations.save.SaveBookValidation;

public class SaveBook {

    private final List<SaveBookValidation> validations;
    private final EventEmitter eventEmitter;

    public SaveBook(EventEmitter eventEmitter, List<SaveBookValidation> validations) {
        this.validations = validations;
        this.eventEmitter = eventEmitter;
    }

    public void save(Book book) {
        validations.forEach(validation -> validation.validate(book));

        this.eventEmitter.emit(new BookSaved(book));
    }
}
