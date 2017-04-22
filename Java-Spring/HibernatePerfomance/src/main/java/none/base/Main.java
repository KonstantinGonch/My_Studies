package none.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by JohnCena on 02.04.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactDAO contactDAO = ctx.getBean("contactDao", ContactDAO.class);
        enlist(contactDAO.findAll());
        enlistWithDetails(contactDAO.findAllWithDetail());
    }
    private static void enlist(List<Contact> infos)
    {
        for(Contact c : infos)
            System.out.println(c);
    }
    private static void enlistWithDetails(List<Contact> infos)
    {
        for (Contact c : infos)
        {
            System.out.println(c);
            if(c.getConstactTelDetails()!=null)
        {
            for (ContactTelDetail ctd : c.getConstactTelDetails())
                System.out.println(ctd);
        }
            if(c.getHobbies()!=null)
            {
                for (Hobby h : c.getHobbies())
                    System.out.println(h);
            }
        }
    }
}
