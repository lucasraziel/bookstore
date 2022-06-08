package com.bookstore.infrastructure.persistence.storemanagement.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.repositories.IBookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BookRepository implements IBookRepository {

    @Override
    public Book save(Book book) {
        log.info("Saving book: {}", book);
        return book;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        log.info("Searching for book with isbn: {}", isbn);
        return Optional.empty();
    }

}
