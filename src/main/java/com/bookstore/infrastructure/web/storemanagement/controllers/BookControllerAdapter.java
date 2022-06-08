package com.bookstore.infrastructure.web.storemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.adapters.services.storemanagement.IBookSaveService;
import com.bookstore.application.storemanagement.controllers.BookController;
import com.bookstore.application.storemanagement.dto.CreateBookData;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;

@RestController
public class BookControllerAdapter implements BookController {

    private IBookSaveService saveBook;

    @Autowired
    public BookControllerAdapter(IBookSaveService saveBook) {
        this.saveBook = saveBook;
    }

    @Override
    @PostMapping("/book")
    public Book create(@RequestBody CreateBookData createBookData) {
        Book book = new Book(createBookData.author(), createBookData.isbn(), createBookData.price(),
                createBookData.title());
        return this.saveBook.save(book);
    }

}
