package com.none;

import java.util.List;

/**
 * Created by JohnCena on 10.04.2017.
 */
public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    long countAll();
}
