import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(java.lang.String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Collector c =(Collector) ctx.getBean("collector");
        //c.describeMap();
        c.describeSet();
        c.describeList();
    }
}

class Collector
{
    @Resource(name = "li")
    private ArrayList<Object> list;
    private Map<String,Object> map;
    private Set<Object> set;

    public void describeMap()
    {
        System.out.println("Map : ");
        for(Map.Entry<String,Object> entry : map.entrySet())
        {
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
    }

    public void describeList()
    {
        System.out.println("List : ");
        for (Object elem : list)
            System.out.println(elem);
    }

    public void describeSet()
    {
        System.out.println("Set : ");
        for (Object o : set)
            System.out.println(o);
    }

    public void setSet(Set<Object> s)
    {
        set=s;
    }

    public void setList(ArrayList<Object> li)
    {
        list=li;
    }

    public void setMap(Map<String,Object> mao)
    {
        map=mao;
    }
}

class Injectable
{
    @Override
    public java.lang.String toString() {
        return ("An Injectable Instance");
    }
}
