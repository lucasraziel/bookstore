package com.bookstore.domains.book.events.booksaved.dto;

import com.bookstore.domains.DataEvent;
import com.bookstore.domains.book.entities.Book;

public record BookSavedData(Book book) implements DataEvent {

}
