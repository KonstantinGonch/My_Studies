import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class Main {
    public static void main(String[] args)
    {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
        messageRenderer renderer = ctx.getBean("messageRenderer", messageRenderer.class);
        renderer.render();
    }
}

interface messageProvider
{
    String getMessage();
}

interface messageRenderer
{
    void render();
    void setMessageProvider(messageProvider provider);
    messageProvider getMessageProvider();
}

@Named("messageProvider")
class ConfigurableMessageProvider implements messageProvider
{
    String message = "default message";

    public ConfigurableMessageProvider()
    {

    }
    @Inject
    @Named("message")
    public ConfigurableMessageProvider(String message)
    {
        this.message=message;
    }

    public String getMessage()
    {
        return message;
    }
}

@Named("messageRenderer")
@Singleton
class StandardOUtMessageRenderer implements messageRenderer
{
    @Inject @Named("messageProvider")
    private messageProvider provider = null;

    public void render()
    {
        System.out.println(provider.getMessage());
    }

    public void setMessageProvider(messageProvider pr)
    {
        provider=pr;
    }

    public messageProvider getMessageProvider()
    {
        return provider;
    }
}
