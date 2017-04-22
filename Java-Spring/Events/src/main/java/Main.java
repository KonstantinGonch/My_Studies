import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 20.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ShoutEventTrigger actor = (ShoutEventTrigger) ctx.getBean("trigger");
        actor.fire("It's a god-awful small affair");
        actor.fire("To the girl with the mousy hair");
    }
}

class ShoutEvent extends ApplicationEvent
{
    private String message;
    public ShoutEvent(Object sender, String message)
    {
        super(sender);
        this.message=message;
    }
    public String getMessage()
    {
        return message;
    }
}

class ShoutEventListener implements ApplicationListener<ShoutEvent>
{
    public void onApplicationEvent(ShoutEvent shoutEvent) {
        System.out.println("Hooked ShoutEvent with message "+shoutEvent.getMessage());
    }
}

class ShoutEventTrigger implements ApplicationContextAware
{
    private ApplicationContext context;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    public void fire(String message)
    {
        context.publishEvent(new ShoutEvent(this, message));
    }
}
