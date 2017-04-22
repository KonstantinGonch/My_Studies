package com.none.classes;

import com.none.qualifiers.Added;

import javax.enterprise.event.Observes;

/**
 * Created by JohnCena on 16.04.2017.
 */
public class BookObserver {
    public void ObserveAdded(@Observes @Added Book book)
    {
        System.out.println("Got new book "+book);
    }
}
