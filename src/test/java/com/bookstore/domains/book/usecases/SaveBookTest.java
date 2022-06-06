package com.bookstore.domains.book.usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookstore.domains.BusinessException;
import com.bookstore.domains.EventEmitter;
import com.bookstore.domains.Handler;
import com.bookstore.domains.book.BookRepository;
import com.bookstore.domains.book.entities.Book;
import com.bookstore.domains.book.events.booksaved.handlers.SaveBookToRepository;
import com.bookstore.domains.book.usecases.save.SaveBook;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.bookstore.domains.book.usecases.validations.save.SaveBookValidation;
import com.bookstore.domains.book.usecases.validations.save.SingleISBNValidation;

@DisplayName("Use Case: Save Book, Domain: Book")
class SaveBookTest {

    private SaveBook saveBook;

    private BookRepository bookRepository;

    @BeforeEach
    void setup() {
        this.bookRepository = mock(BookRepository.class);
        SaveBookValidation singleISBNValidation = new SingleISBNValidation(bookRepository);
        List<SaveBookValidation> saveBookValidations = new ArrayList<SaveBookValidation>();
        saveBookValidations.add(singleISBNValidation);
        EventEmitter eventEmitter = new EventEmitter();

        List<Handler> handlers = new ArrayList<Handler>();
        handlers.add(new SaveBookToRepository(bookRepository));
        eventEmitter.register("BookSaved", handlers);
        this.saveBook = new SaveBook(eventEmitter, saveBookValidations);
    }

    @DisplayName("Should save a book")
    @Test
    void shouldSaveABook() {
        Book book = new Book("123456789", "1213232", "J.R.R. Tolkien", 1954,
                "The Lord of the Rings");
        when(bookRepository.findByIsbn(book.isbn())).thenReturn(Optional.empty());
        when(bookRepository.save(book)).thenReturn(book);
        this.saveBook.save(book);
        verify(bookRepository, times(1)).save(book);
        verify(bookRepository, times(1)).findByIsbn(book.isbn());
    }

    @DisplayName("Should thrown an error when ISBN exists")
    @Test
    void shouldNotSaveBookWhenISBNExists() {
        Book book = new Book("123456789", "123213213", "J.R.R. Tolkien", 1954,
                "The Lord of the Rings");
        when(bookRepository.findByIsbn(book.isbn())).thenReturn(Optional.of(book));

        assertThrows(BusinessException.class, () -> this.saveBook.save(book));
        verify(bookRepository, times(1)).findByIsbn(book.isbn());
    }
}
