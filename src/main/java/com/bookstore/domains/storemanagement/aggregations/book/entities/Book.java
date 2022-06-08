package com.bookstore.domains.storemanagement.aggregations.book.entities;

import java.util.UUID;

import com.bookstore.domains.storemanagement.shared.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book implements Entity {

    String author;
    String title;
    String isbn;
    Integer price;
    String id;

    public Book(String author, String isbn, Integer price, String title) {
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.title = title;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return id.equals(book.id) && this.isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + isbn.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title +
                '\'' + ", author='" + author + '\'' + ", isbn='"
                + isbn + '\'' + ", price="
                + price + ", id='" + id + '\'' + '}';
    }
}
