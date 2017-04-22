import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JohnCena on 13.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Speaker speaker = new Speaker();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Speakable speakable = (Speakable) context.getBean("sample1");
        speaker.setSpeaker(speakable);
        speaker.speak();
        Speakable sp = (Speakable) context.getBean("sample2");
        speaker.setSpeaker(sp);
        speaker.speak();
    }
}
