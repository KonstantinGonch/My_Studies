package com.none;

import java.util.List;

/**
 * Created by JohnCena on 19.04.2017.
 */
public interface PersonService {
    Person save(Person p);
    void delete(Person p);
    List<Person> findAll();
}
