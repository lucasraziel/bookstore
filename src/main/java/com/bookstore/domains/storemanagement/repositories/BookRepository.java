package com.bookstore.domains.storemanagement.repositories;

import java.util.List;
import java.util.Optional;

import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.shared.Repository;

public interface BookRepository extends Repository {

    Book save(Book book);

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(String id);

    void delete(Book book);

    void deleteById(String id);

    Book update(Book book);

    List<Book> findByTitle(String title);

    List<Book> getAll(int page, int limit);
}
