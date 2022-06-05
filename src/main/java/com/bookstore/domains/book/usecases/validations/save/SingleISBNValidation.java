package com.bookstore.domains.book.usecases.validations.save;

import com.bookstore.domains.BusinessException;
import com.bookstore.domains.book.Book;
import com.bookstore.domains.book.BookRepository;

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
