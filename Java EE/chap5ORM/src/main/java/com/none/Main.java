package com.none;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.persistence.EntityTransaction;

/**
 * Created by JohnCena on 19.04.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        PersonService service = container.instance().select(PersonServiceImpl.class).get();
        AddressService jservice =container.instance().select(AddressServiceImpl.class).get();

        Person p1 = new Person();
        p1.setName("Jenna");
        p1.setSurname("Angel");
        Job j1 = new Job();
        j1.setJobName("Director");
        j1.setSalary(2000);
        p1.setJob(j1);

        Person p2 = new Person();
        p2.setName("Varin");
        p2.setSurname("Omega");
        Job j2 = new Job();
        j2.setJobName("Colonel");
        j2.setSalary(1700);
        p2.setJob(j2);

        jservice.save(j1);
        jservice.save(j2);
        service.save(p1);
        service.save(p2);

        for (Person p : service.findAll())
            System.out.println(p);

        service.delete(p1);
        service.delete(p2);
        jservice.delete(j1);
        jservice.delete(j2);
    }
}
