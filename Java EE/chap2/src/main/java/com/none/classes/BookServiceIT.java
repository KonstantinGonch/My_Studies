package com.none.classes;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by JohnCena on 16.04.2017.
 */
public class BookServiceIT {
    @Test
    public void shouldCheck()
    {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("FSB", 10.0f, "Secret book");
        assertTrue(book.getNumber().startsWith("MOCK"));
        weld.shutdown();
    }

}
