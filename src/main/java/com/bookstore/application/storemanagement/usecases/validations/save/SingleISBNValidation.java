package com.bookstore.application.storemanagement.usecases.validations.save;

import com.bookstore.application.shared.BusinessException;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.repositories.IBookRepository;

public class SingleISBNValidation implements SaveBookValidation {

    private final IBookRepository bookRepository;

    public SingleISBNValidation(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean validate(Book book) {
        boolean isThereABook = !this.bookRepository.findByIsbn(book.getIsbn()).isEmpty();

        if (!isThereABook) {
            return true;
        }

        throw new BusinessException("This book already exists");
    }

}
