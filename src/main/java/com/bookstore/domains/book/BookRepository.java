package com.bookstore.domains.book;

import java.util.List;
import java.util.Optional;

import com.bookstore.domains.book.entities.Book;

public interface BookRepository {

    Book save(Book book);

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(String id);

    void delete(Book book);

    void deleteById(String id);

    Book update(Book book);

    List<Book> findByTitle(String title);

    List<Book> getAll(int page, int limit);
}
