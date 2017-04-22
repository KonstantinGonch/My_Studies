import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 01.04.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactDao contactDao = new JdbcContactDao();
        System.out.println(contactDao.findFirstNameById(new Long(1)));
    }
}
