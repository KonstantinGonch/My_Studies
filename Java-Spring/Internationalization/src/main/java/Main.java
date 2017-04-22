import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by JohnCena on 20.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Locale eng = Locale.ENGLISH;
        Locale rus = new Locale("ru");
        System.out.println(ctx.getMessage("jess", null, eng)+" "+ctx.getMessage("jess",null, rus));
        System.out.println(ctx.getMessage("coven",null,eng)+" means "+ctx.getMessage("coven", null, rus));
        System.out.println(ctx.getMessage("nameMsg", new String[]{"Not","Defined"}, eng));
        System.out.println(ctx.getMessage("nameMsg", new String[]{"Не","Определено"}, rus));
    }
}
