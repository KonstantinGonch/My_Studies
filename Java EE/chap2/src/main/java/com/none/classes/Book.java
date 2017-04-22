package com.none.classes;

/**
 * Created by JohnCena on 15.04.2017.
 */
public class Book {
    private String title;
    private Float price;
    private String description;
    private String number;

    public Book(String title, Float price, String description)
    {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString()
    {
        return title+" "+price+" "+description+" "+number;
    }
}
