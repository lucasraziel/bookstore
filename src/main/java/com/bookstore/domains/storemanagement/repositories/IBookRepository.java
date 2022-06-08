package com.bookstore.domains.storemanagement.repositories;

import java.util.Optional;

import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.shared.Repository;

public interface IBookRepository extends Repository {

    Book save(Book book);

    Optional<Book> findByIsbn(String isbn);

}
