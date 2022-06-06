package com.bookstore.domains.book.usecases.save;

import java.util.List;
import com.bookstore.domains.book.usecases.validations.save.SaveBookValidation;
import com.bookstore.domains.book.BookRepository;
import com.bookstore.domains.book.entities.Book;

public class SaveBook {

    private final List<SaveBookValidation> validations;
    private final BookRepository bookRepository;

    public SaveBook(BookRepository bookRepository, List<SaveBookValidation> validations) {
        this.bookRepository = bookRepository;
        this.validations = validations;
    }

    public void save(Book book) {
        validations.forEach(validation -> validation.validate(book));
        bookRepository.save(book);
    }
}
