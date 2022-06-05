package com.bookstore.domains.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookstore.domains.BusinessException;
import com.bookstore.domains.book.usecases.save.SaveBook;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.bookstore.domains.book.usecases.validations.save.SaveBookValidation;
import com.bookstore.domains.book.usecases.validations.save.SingleISBNValidation;

@DisplayName("Use Case: Save Book, Domain: Book")
public class SaveBookTest {

    private SaveBook saveBook;

    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        this.bookRepository = mock(BookRepository.class);
        SaveBookValidation singleISBNValidation = new SingleISBNValidation(bookRepository);
        List<SaveBookValidation> saveBookValidations = new ArrayList<SaveBookValidation>();
        saveBookValidations.add(singleISBNValidation);
        this.saveBook = new SaveBook(bookRepository, saveBookValidations);
    }

    @DisplayName("Should save a book")
    @Test
    public void shouldSaveABook() {
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
    public void shouldNotSaveBookWhenISBNExists() {
        Book book = new Book("123456789", "123213213", "J.R.R. Tolkien", 1954,
                "The Lord of the Rings");
        when(bookRepository.findByIsbn(book.isbn())).thenReturn(Optional.of(book));

        assertThrows(BusinessException.class, () -> this.saveBook.save(book));
        verify(bookRepository, times(1)).findByIsbn(book.isbn());
    }
}
