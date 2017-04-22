import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Exec exe = (Exec) ctx.getBean("a");
        Exec2 exe2 = (Exec2) ctx.getBean("b");
        System.out.println(exe);
        System.out.println(exe2);
    }
}

class Exec
{
    private String name;
    public void setName(String a)
    {
        name = a;
    }
    @Override
    public String toString()
    {
        return "Name: "+name;
    }
}

class Exec2
{
    @Value("#{cont.getName()}")
    private String name;
    public void setName(String a)
    {
        name = a;
    }
    @Override
    public String toString()
    {
        return "Name: "+name;
    }
}

class Container
{
    private String name = "Jenna";
    public String getName()
    {
        return "Jenna";
    }
}
