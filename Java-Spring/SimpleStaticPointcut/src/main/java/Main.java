import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created by JohnCena on 24.03.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Performer starterPErformer = new Performer();
        ProxyFactory pf = new ProxyFactory();
        Pointcut simplePointcut = new SimplePointcut();
        InjectableAdvice injectableAdvice = new InjectableAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(simplePointcut,injectableAdvice);
        pf.addAdvisor(advisor);
        pf.setTarget(starterPErformer);
        Performer modifiedPErformer = (Performer) pf.getProxy();
        starterPErformer.perform();
        starterPErformer.execute();
        modifiedPErformer.perform();
        modifiedPErformer.execute();
    }
}

class SimplePointcut extends StaticMethodMatcherPointcut
{
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                return (aClass.equals(Performer.class));
            }
        };
    }

    public boolean matches(Method method, Class<?> aClass) {
        return ("perform".equals(method.getName()));
    }
}

class InjectableAdvice implements MethodBeforeAdvice
{
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Called method "+method.getName());
    }
}

class Performer
{
    void perform()
    {
        System.out.println("Performing...");
    }
    void execute()
    {
        System.out.println("Executing...");
    }
}
