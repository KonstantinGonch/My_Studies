package com.none;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohnCena on 08.04.2017.
 */
public class Main{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
        ContactSummaryUntypeImpl csul = ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
        csul.displayAllContactSummary();

        ContactSummaryService css = ctx.getBean("contactSummaryService", ContactSummaryService.class);
        System.out.println("Getting list from ContactServiceImpl: ");
        for (ContactSummary cs : css.findAll())
            System.out.println(cs);

        listAnswer(contactService.findAll());
        listAnswer(contactService.findAllByNativeQuery());
        System.out.println("Fetching complex info: ");
        listAnswer(contactService.findAllWithDetail());
        System.out.println("Getting contact with id=3");
        List<Contact> ans = new ArrayList<Contact>();
        ans.add(contactService.findById(3));
        listAnswer(ans);

    }
    private static void listAnswer(List<Contact> values)
    {
        System.out.println("\n");
        for (Contact contact : values)
        {
            System.out.println(contact);
            if(contact.getContactTelDetails()!=null)
            {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails())
                {
                    System.out.println("\t"+contactTelDetail);
                }
            }
            if(contact.getHobbies()!=null)
            {
                for(Hobby hobby : contact.getHobbies())
                {
                    System.out.println("\t\t"+hobby);
                }
            }
        }
    }
}
