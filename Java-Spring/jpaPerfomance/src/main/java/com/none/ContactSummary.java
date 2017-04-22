package com.none;

import java.io.Serializable;

/**
 * Created by JohnCena on 09.04.2017.
 */
public class ContactSummary implements Serializable {
    private String lastName;
    private String firstName;
    private String homeTelNumber;

    public ContactSummary (String firstName, String lastName, String homeTElNumber)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.homeTelNumber = homeTElNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHomeTelNumber() {
        return homeTelNumber;
    }

    public void setHomeTelNumber(String homeTelNumber) {
        this.homeTelNumber = homeTelNumber;
    }
    public String toString () {
        return "First name: " + firstName + " Last Name: " + lastName
                + " Home Phone: " + homeTelNumber;
    }
}
