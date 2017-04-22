import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * Created by JohnCena on 29.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Person p = new Person();
        ProxyFactory pf = new ProxyFactory();
        ComposablePointcut pc = new ComposablePointcut(new GetMethodMatcher());
        //pc.union(new SetMethodMatcher()); uncomment to enable extra perfomance
        pc.intersection(new GetAgeMethodMatcher());
        pf.setTarget(p);
        pf.addAdvisor(new DefaultPointcutAdvisor(pc,new DetectionAdvice()));
        Person m = (Person) pf.getProxy();
        m.getName();
        m.getAge();
        m.setName("Molly");
    }
}

class Person
{
    String getName()
    {
        return "Jenna Angel";
    }
    void setName(String n)
    {
        System.out.println("Called setName() "+n);
    }
    int getAge()
    {
        return 32;
    }
}

class GetMethodMatcher extends StaticMethodMatcher
{
    public boolean matches(Method method, Class<?> aClass) {
        return (method.getName().startsWith("get"));
    }
}

class SetMethodMatcher extends StaticMethodMatcher
{
    public boolean matches(Method method, Class<?> aClass) {
        return (method.getName().startsWith("set"));
    }
}

class GetAgeMethodMatcher extends StaticMethodMatcher
{
    public boolean matches(Method method, Class<?> aClass) {
        return ("getAge".equals(method.getName()));
    }
}

class DetectionAdvice implements MethodBeforeAdvice
{
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(">>>Calling "+method.getName());
    }
}