package com.bookstore.infrastructure.web.storemanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.adapters.services.storemanagement.IBookSaveService;
import com.bookstore.application.storemanagement.usecases.save.SaveBook;
import com.bookstore.application.storemanagement.usecases.validations.save.SaveBookValidation;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.repositories.IBookRepository;
import com.bookstore.infrastructure.web.shared.EventEmitterProvider;

@Service
public class BookSaveService implements IBookSaveService {

    private SaveBook saveBook;

    @Autowired
    public BookSaveService(IBookRepository bookRepository, EventEmitterProvider eventEmitterProvider) {
        List<SaveBookValidation> validations = new ArrayList<>();
        this.saveBook = new SaveBook(eventEmitterProvider.getEventEmitter(), validations, bookRepository);
    }

    @Override
    public Book save(Book book) {
        return this.saveBook.save(book);
    }

}
