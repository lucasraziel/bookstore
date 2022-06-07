package com.bookstore.application.storemanagement.events;

import java.util.Date;

import com.bookstore.application.shared.Event;
import com.bookstore.application.storemanagement.dto.BookSavedData;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;

public class BookSaved extends Event<BookSavedData> {
    public BookSaved(Book book) {
        this.setEventId("BookSaved");
        this.setEventData(new BookSavedData(book));
        this.setEventDate(new Date());
    }
}
