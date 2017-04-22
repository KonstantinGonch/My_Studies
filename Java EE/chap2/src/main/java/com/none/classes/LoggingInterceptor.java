package com.none.classes;

import com.none.qualifiers.Loggable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggingInterceptor {
    @AroundInvoke
    public Object logMeth(InvocationContext ic) throws Exception
    {
        System.out.println("Hooked "+ic.getTarget().toString());
        return ic.proceed();
    }
}
