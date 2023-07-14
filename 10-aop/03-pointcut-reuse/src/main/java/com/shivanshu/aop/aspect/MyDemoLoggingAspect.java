package com.shivanshu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.shivanshu.aop.dao.*.*(..))")
    private void forDAOPackage() {}

    @Before("forDAOPackage()")
    public void beforeAnyMethodInDAOPackage() {
        System.out.println("\n====>>>Executing Before advice on method");
    }

    @Before("forDAOPackage()")
    public void performAPIAnalytics() {
        System.out.println("\n====>>>Peforming API Analytics on Method");
    }
}
