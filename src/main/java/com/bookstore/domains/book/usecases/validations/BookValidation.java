package com.bookstore.domains.book.usecases.validations;

import com.bookstore.domains.book.entities.Book;

public interface BookValidation {
    public boolean validate(Book book);
}
