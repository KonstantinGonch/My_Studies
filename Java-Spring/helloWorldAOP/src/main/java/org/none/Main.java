package org.none;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args)
    {
        MessageWriter target = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);
        MessageWriter proxy = (MessageWriter) pf.getProxy();
        target.writeMessage();
        proxy.writeMessage();
    }
}

class MessageWriter
{
    public void writeMessage()
    {
        System.out.println("World");
    }
}

class MessageDecorator implements MethodInterceptor
{
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello, ");
        Object ret = methodInvocation.proceed();
        System.out.println("!");
        return ret;
    }
}
