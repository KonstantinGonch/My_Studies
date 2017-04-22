import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Main {
    public static void main(String[] args)
    {
        TestBean tb = new TestBean();
        ProxyFactory pf = new ProxyFactory();
        AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forClassAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
        pf.setTarget(tb);
        pf.addAdvisor(advisor);
        TestBean m = (TestBean) pf.getProxy();
        m.Do();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface AdviceRequired
{

}

class SimpleAdvice implements MethodInterceptor
{
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Calling advice...");
        Object retVal = methodInvocation.proceed();
        System.out.println("Finished...");
        return retVal;
    }
}

class TestBean
{
    @AdviceRequired
    void Do()
    {
        System.out.println("Executing...");
    }
}
