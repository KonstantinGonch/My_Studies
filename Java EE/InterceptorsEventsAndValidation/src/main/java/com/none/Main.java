package com.none;

import com.none.models.Person;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by JohnCena on 16.04.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();
        Person p = weldContainer.instance().select(Person.class).get();
        System.out.println("Tests for CDI: Person says ");
        p.setAddress("RF, MSC,  Zelenodolskaya 5");
        p.speak();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(p);
        System.out.println(violations.size());
        p.setAddress("NY");
        violations = validator.validate(p);
        System.out.println(violations.size());
        System.out.println(violations.iterator().next().getMessage());
    }
}
