import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 19.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext con = new ClassPathXmlApplicationContext("spring-config.xml");
        Injectable in1 = (Injectable) con.getBean("inj");
        Injectable in2 = (Injectable) con.getBean("inj");
        System.out.println(in1==in2);
    }
}

class Injectable
{
    String name;
}
