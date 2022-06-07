package com.bookstore.application.storemanagement.dto;

import com.bookstore.application.shared.DataEvent;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;

public record BookSavedData(Book book) implements DataEvent {

}
