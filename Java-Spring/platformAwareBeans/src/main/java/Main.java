import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 19.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Bean b = (Bean) ctx.getBean("bea");
    }
}

class Bean implements BeanNameAware, ApplicationContextAware
{
    public void setBeanName(String s) {
        System.out.println("Name " + s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("In setAppContext() ");
    }
}
