package com.none.classes;

import com.none.interfaces.NumberGenerator;
import com.none.qualifiers.Added;
import com.none.qualifiers.Loggable;
import com.none.qualifiers.ThirteenDigits;

import javax.enterprise.event.Event;
import javax.inject.Inject;

@Loggable
public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    @Inject @Added
    private Event<Book> bookCreatedEvent;

    public Book createBook(String title, Float price, String description)
    {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        bookCreatedEvent.fire(book);
        return book;
    }
}
