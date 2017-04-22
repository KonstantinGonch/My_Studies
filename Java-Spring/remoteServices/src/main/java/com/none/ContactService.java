package com.none;

import com.none.Contact;

import java.util.List;

/**
 * Created by JohnCena on 15.04.2017.
 */
public interface ContactService {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
