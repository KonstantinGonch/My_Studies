package com.none;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="contact")
@NamedQueries({@NamedQuery(name="Contact.findAll", query = "select c from Contact c"),
@NamedQuery(name="Contact.countAll", query = "select count(c) from Contact c")})
public class Contact implements Serializable {
    private Long id;
    private int version;
    private String lastName;
    private String firstNAme;
    private Date birthDate;

    public Contact()
    {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name="VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="FIRST_NAME")
    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString()
    {
        return "Contact - Id: " + id + ", First name: " + firstNAme
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
