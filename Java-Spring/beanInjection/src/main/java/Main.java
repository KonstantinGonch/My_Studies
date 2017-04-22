import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 15.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Performer p = (Performer) ctx.getBean("performer");
        p.Perform();
    }
}

interface Injectable
{
    void Do();
}

class Injector implements Injectable{
    public void Do()
    {
        System.out.println("In Injector");
    }
}

class Performer
{
    Injectable inj;
    public void setInj(Injectable i)
    {
        inj=i;
    }
    public void Perform()
    {
        inj.Do();
    }
}
