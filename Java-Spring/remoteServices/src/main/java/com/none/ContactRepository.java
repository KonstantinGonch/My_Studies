package com.none;

import com.none.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JohnCena on 15.04.2017.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);
}
