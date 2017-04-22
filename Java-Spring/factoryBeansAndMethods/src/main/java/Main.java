import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 20.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Instance i = (Instance) ctx.getBean("ins");
        i.Do();
    }
}

class Instance
{
    public void Do()
    {
        System.out.println("I am an instance");
    }
}

class InstanceFactory
{
    public Instance createInstance()
    {
        return new Instance();
    }
}
