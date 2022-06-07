package com.bookstore.application.storemanagement.usecases.validations;

import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;

public interface BookValidation {
    public boolean validate(Book book);
}
