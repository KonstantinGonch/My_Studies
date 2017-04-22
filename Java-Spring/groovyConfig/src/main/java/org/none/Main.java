package org.none;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Created by JohnCena on 22.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new GenericGroovyApplicationContext(beans.class);
        Person jenna = ctx.getBean("person", Person.class);
        System.out.println(jenna);
    }
}

class Person
{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return ("Name: "+name+" Age: "+age);
    }
}
