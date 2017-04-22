import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by JohnCena on 21.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Configs.class);
        Injectable inj = ctx.getBean("injectable", Injectable.class);
        inj.Do();
    }
}

class Injectable
{
    private String message;
    void Do()
    {
        System.out.println("Executing with "+message);
    }
    public void setMessage(String s)
    {
        message=s;
    }
    public String getMessage()
    {
        return message;
    }
}
