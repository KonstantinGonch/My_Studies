package com.none;

import java.util.List;

/**
 * Created by JohnCena on 08.04.2017.
 */
public interface ContactService {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(long id);
    Contact save(Contact contact);
    void delete(Contact contact);
    List<Contact> findAllByNativeQuery();
}
