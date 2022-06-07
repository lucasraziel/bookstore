package com.bookstore.application.storemanagement.usecases.validations.save;

import com.bookstore.application.shared.BusinessException;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.repositories.BookRepository;

public class SingleISBNValidation implements SaveBookValidation {

    private final BookRepository bookRepository;

    public SingleISBNValidation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean validate(Book book) {
        boolean isThereABook = !this.bookRepository.findByIsbn(book.isbn()).isEmpty();

        if (!isThereABook) {
            return true;
        }

        throw new BusinessException("This book already exists");
    }

}
