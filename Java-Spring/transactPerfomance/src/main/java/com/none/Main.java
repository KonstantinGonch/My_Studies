package com.none;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by JohnCena on 10.04.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactService contactService = ctx.getBean("contactService", ContactService.class);
        List<Contact> contacts = contactService.findAll();
        for (Contact c : contacts)
            System.out.println(c);
    }
}
