package com.none.interceptors;

import com.none.models.Person;

import javax.enterprise.event.Observes;

/**
 * Created by JohnCena on 16.04.2017.
 */
public class PersonListener {
    public void hook(@Observes Person p)
    {
        System.out.println("Hooked Person's speech wia PersonListener event handler");
    }
}
