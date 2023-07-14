package com.shivanshu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // pointcut experession
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("======>>>> Executing @Before advice on addAccount()");
    }
}
