import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohnCena on 01.04.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        BaseDao dao = ctx.getBean("SimpleJdbcDao", SimpleJdbcDao.class);
        System.out.println(dao.getFullNameById(2));
        List<Person> list = new ArrayList<Person>();
        list=dao.fetchAllNames();
        for(Person p: list)
            System.out.println(p);
        System.out.println("Using MappingSqlQuery: ");
        list=dao.fetchAllNamesByClass();
        for(Person p: list)
            System.out.println(p);
        System.out.println("Trying to find record with first_name = Jude");
        List<Person> answer = dao.findPersonByFirstName("Jude");
        if(answer==null)
            System.out.println("Didn't found Jude");
        else
        {
            for (Person p : answer)
                System.out.println(p);
        }
        System.out.println("Getting Corrupted Record (id=6): ");
        for (Person p : dao.getPersonById(6))
            System.out.println(p);
        System.out.println("Updating data...");
        dao.update(6);
        System.out.println("Getting Record (id=6): ");
        for (Person p : dao.getPersonById(6))
            System.out.println(p);
    }
}
