package com.bookstore.domains.book.events.booksaved;

import java.util.Date;

import com.bookstore.domains.Event;
import com.bookstore.domains.book.entities.Book;
import com.bookstore.domains.book.events.booksaved.dto.BookSavedData;

public class BookSaved extends Event<BookSavedData> {
    public BookSaved(Book book) {
        this.setEventId("BookSaved");
        this.setEventData(new BookSavedData(book));
        this.setEventDate(new Date());
    }
}
