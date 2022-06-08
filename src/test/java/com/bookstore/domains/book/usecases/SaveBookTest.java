package com.bookstore.domains.book.usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookstore.adapters.services.email.IEmailService;
import com.bookstore.adapters.services.email.entity.Email;
import com.bookstore.application.bookcatalogs.handlers.SendEmailToTeamNewBookEventHandler;
import com.bookstore.application.shared.BusinessException;
import com.bookstore.application.shared.EventEmitter;
import com.bookstore.application.shared.Handler;
import com.bookstore.application.storemanagement.usecases.save.SaveBook;
import com.bookstore.application.storemanagement.usecases.validations.save.SaveBookValidation;
import com.bookstore.application.storemanagement.usecases.validations.save.SingleISBNValidation;
import com.bookstore.domains.storemanagement.aggregations.book.entities.Book;
import com.bookstore.domains.storemanagement.repositories.IBookRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Use Case: Save Book, Domain: Book")
class SaveBookTest {

    private SaveBook saveBook;

    private IBookRepository bookRepository;

    private IEmailService emailService;

    @BeforeEach
    void setup() {
        this.bookRepository = mock(IBookRepository.class);
        SaveBookValidation singleISBNValidation = new SingleISBNValidation(bookRepository);
        List<SaveBookValidation> saveBookValidations = new ArrayList<SaveBookValidation>();
        saveBookValidations.add(singleISBNValidation);
        EventEmitter eventEmitter = new EventEmitter();

        this.emailService = mock(IEmailService.class);

        Handler sendEmailToTeamNewBookEventHandler = new SendEmailToTeamNewBookEventHandler(emailService);

        List<Handler> handlers = new ArrayList<Handler>();
        handlers.add(sendEmailToTeamNewBookEventHandler);
        eventEmitter.register("BookSaved", handlers);
        this.saveBook = new SaveBook(eventEmitter, saveBookValidations, bookRepository);
    }

    @DisplayName("Should save a book")
    @Test
    void shouldSaveABook() {
        Book book = new Book("J.R.R. Tolkien", "123456789", 1954,
                "The Lord of the Rings");
        when(bookRepository.findByIsbn(book.getIsbn())).thenReturn(Optional.empty());
        when(bookRepository.save(book)).thenReturn(book);
        this.saveBook.save(book);
        verify(bookRepository, times(1)).save(book);
        verify(bookRepository, times(1)).findByIsbn(book.getIsbn());
        verify(this.emailService, atLeastOnce()).send(any(Email.class));
    }

    @DisplayName("Should thrown an error when ISBN exists")
    @Test
    void shouldNotSaveBookWhenISBNExists() {
        Book book = new Book("J.R.R. Tolkien", "123456789", 1954,
                "The Lord of the Rings");
        when(bookRepository.findByIsbn(book.getIsbn())).thenReturn(Optional.of(book));

        assertThrows(BusinessException.class, () -> this.saveBook.save(book));
        verify(bookRepository, times(1)).findByIsbn(book.getIsbn());
    }
}
