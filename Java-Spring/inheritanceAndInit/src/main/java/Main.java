import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 19.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Parent p = (Parent) ctx.getBean("parent");
        Child c = (Child) ctx.getBean("child");
    }
}

class Parent
{
    private String name;
    private int age;

    public void setAge(int ar)
    {
        age=ar;
    }

    public void setName(String n)
    {
        name=n;
    }

    public void init()
    {
        System.out.println("Name: "+name+" Age: "+age);
    }
}

class Child extends Parent
{
    private String name;
    private int age;

    public void setAge(int ar)
    {
        age=ar;
    }

    public void setName(String n)
    {
        name=n;
    }
}
