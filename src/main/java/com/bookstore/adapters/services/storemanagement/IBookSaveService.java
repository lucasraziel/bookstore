package com.bookstore.adapters.services.storemanagement;

import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;

public interface IBookSaveService {

    public Book save(Book book);

}
