import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Created by JohnCena on 14.03.2017.
 */
public class Main {
    public  static void main(String[] args)
    {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("spring-config.xml");
        Speakable speaker = (Speakable) factory.getBean("speaker");
        speaker.speak();
    }
}

interface Speakable
{
    void speak();
}

class Speaker implements Speakable
{
    public void speak()
    {
        System.out.println("Hi There!");
    }
}
