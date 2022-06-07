package com.bookstore.application.storemanagement.usecases.save;

import java.util.List;

import com.bookstore.application.shared.EventEmitter;
import com.bookstore.application.storemanagement.events.BookSaved;
import com.bookstore.application.storemanagement.usecases.validations.save.SaveBookValidation;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.repositories.BookRepository;

public class SaveBook {

    private final List<SaveBookValidation> validations;
    private final EventEmitter eventEmitter;
    private final BookRepository bookRepository;

    public SaveBook(EventEmitter eventEmitter, List<SaveBookValidation> validations, BookRepository bookRepository) {
        this.validations = validations;
        this.eventEmitter = eventEmitter;
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        validations.forEach(validation -> validation.validate(book));

        this.bookRepository.save(book);

        this.eventEmitter.emit(new BookSaved(book));
    }
}
