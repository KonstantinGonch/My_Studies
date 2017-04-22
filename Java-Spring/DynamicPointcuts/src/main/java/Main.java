import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created by JohnCena on 25.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Performer def = new Performer();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(new DynamicMather(), new DoneAdvise()));
        pf.setTarget(def);

        Performer modif = (Performer) pf.getProxy();

        def.execute();
        modif.execute();
        def.perform(10);
        def.perform(100);
        modif.perform(10);
        modif.perform(100);
    }
}

class DynamicMather extends DynamicMethodMatcherPointcut
{
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                return (aClass.equals(Performer.class));
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for "+method.getName());
        return (method.getName().equals("perform"));
    }

    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("Dynamic check for "+method.getName());
        return ((Integer)objects[0]!=100);
    }
}

class Performer
{
    void perform(int arg)
    {
        System.out.println("Performing with value: "+arg);
    }
    void execute()
    {
        System.out.println("Executing...");
    }
}

class DoneAdvise implements AfterReturningAdvice
{
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Done");
    }
}
