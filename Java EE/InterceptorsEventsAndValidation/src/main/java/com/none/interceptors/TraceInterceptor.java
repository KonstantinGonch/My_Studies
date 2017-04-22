package com.none.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor @Traceable
public class TraceInterceptor {
    @AroundInvoke
    public Object hook(InvocationContext ic) throws Exception
    {
        System.out.println("Hooked "+ic.getMethod().getName());
        return ic.proceed();
    }
}
