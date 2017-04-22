package com.none.models;

import com.none.interceptors.Traceable;
import com.none.qualifiers.LongQuote;
import com.none.qualifiers.ShortQuote;
import com.none.validators.IsRussian;

import javax.enterprise.event.Event;
import javax.inject.Inject;

@Traceable
public class Person {
    @Inject @LongQuote
    private QuoteGenerator quoteGenerator;

    @IsRussian
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Inject
    private Event<Person> speakEvent;

    public void speak()
    {
        System.out.println(quoteGenerator.generateQuote());
        speakEvent.fire(this);
    }
}
