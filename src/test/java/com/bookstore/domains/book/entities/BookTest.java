package com.bookstore.domains.book.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;

@DisplayName("entity: Book, Domain: Book")
class BookTest {

    private Book book;

    @BeforeEach
    void setup() {
        this.book = new Book("J.R.R. Tolkien", "123456789", 1954,
                "The Lord of the Rings");
    }

    @DisplayName("should have a title")
    @Test
    void shouldHaveATitle() {
        assertEquals("The Lord of the Rings", book.getTitle());
    }

    @DisplayName("should have an ISBN")
    @Test
    void shouldHaveAnISBN() {
        assertEquals("123456789", book.getIsbn());
    }

    @DisplayName("should have an author")
    @Test
    void shouldHaveAnAuthor() {
        assertEquals("J.R.R. Tolkien", book.getAuthor());
    }

    @DisplayName("should have a price")
    @Test
    void shouldHaveAPrice() {
        assertEquals(1954, book.getPrice());
    }

    @DisplayName("should have an id")
    @Test
    void shouldHaveAnId() {
        book.setId("1213232");
        assertEquals("1213232", book.getId());
    }

    @DisplayName("should be equal to another book with the same id and isbn")
    @Test
    void shouldBeEqualToAnotherBookWithTheSameIdAndIsbn() {
        Book anotherBook = new Book("J.R.R. Tolkien", "123456789",
                1954, "The Lord of the Rings");
        this.book.setId(anotherBook.getId());
        assertEquals(this.book, anotherBook);
    }

    @DisplayName("should have a hash code")
    @Test
    void shouldHaveAHashCode() {
        int result = book.getId().hashCode();
        result = 31 * result + "123456789".hashCode();
        assertEquals(result, book.hashCode());
    }

    @DisplayName("should be converted to a string")
    @Test
    void shouldBeConvertedToAString() {
        assertEquals(
                "Book{title='The Lord of the Rings', author='J.R.R. Tolkien', isbn='123456789', price=1954, id='"
                        + book.getId() + "'}",
                book.toString());
    }

    @DisplayName("should not be equal to another book with different id")
    @Test
    void shouldNotBeEqualToAnotherBookWithDifferentId() {
        Book anotherBook = new Book("J.R.R. Tolkien", "123456789",
                1954, "The Lord of the Rings");
        assertNotEquals(book, anotherBook);
    }

    @DisplayName("should not be equal to another book with different isbn")
    @Test
    void shouldNotBeEqualToAnotherBookWithDifferentIsbn() {
        Book anotherBook = new Book("J.R.R. Tolkien", "123456783",
                1954, "The Lord of the Rings");

        anotherBook.setId("1213232");
        assertNotEquals(book, anotherBook);
    }

    @DisplayName("should be equal to same book")
    @Test
    void shouldBeEqualToSameBook() {
        assertEquals(book, book);
    }

    @DisplayName("should not be equal to null")
    @Test
    void shouldNotBeEqualToNull() {
        assertNotEquals(null, book);
    }

    @DisplayName("should not be equal to another class")
    @Test
    void shouldNotBeEqualToAnotherClass() {
        assertNotEquals(book, new Object());
    }

}
