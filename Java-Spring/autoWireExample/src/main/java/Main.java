import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 19.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Collection collection = null;
        System.out.println("Calling ByName: ");
        collection= (Collection) ctx.getBean("byNam");
        System.out.println("Calling ByType: ");
        collection = (Collection) ctx.getBean("byTyp");
        System.out.println("Calling ByCons: ");
        collection = (Collection) ctx.getBean("byCons");
    }
}

class Foo
{

}

class Bar
{

}

class Collection
{
    private Foo foo;
    private Foo foo2;
    private Bar bar1;

    public Collection()
    {

    }

    public Collection(Foo foo)
    {
        System.out.println("Called 1-parameter constructor");
    }

    public Collection(Foo foo, Bar bar)
    {
        System.out.println("Called 2-parameter constructor");
    }

    void setFoo(Foo foo)
    {
        System.out.println("SetFoo() called");
    }

    void setFoo2(Foo foo)
    {
        System.out.println("SetFoo2() called");
    }

    void setBar1(Bar bar)
    {
        System.out.println("SetBar1() called");
    }
}
