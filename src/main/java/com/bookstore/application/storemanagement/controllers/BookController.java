package com.bookstore.application.storemanagement.controllers;

import com.bookstore.application.storemanagement.dto.CreateBookData;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;

public interface BookController {

    public Book create(CreateBookData createBookData);

}
