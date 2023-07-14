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

    @Pointcut("execution(* com.shivanshu.aop.dao.*.get*(..))")
    private void forGetter() {}

    @Pointcut("execution(* com.shivanshu.aop.dao.*.set*(..))")
    private void forSetter() {}

    @Pointcut("forDAOPackage() && !(forGetter() || forSetter())")
    private void forDAOPackageNoGetterNoSetter() {}

    @Before("forDAOPackageNoGetterNoSetter()")
    public void beforeAnyMethodInDAOPackage() {
        System.out.println("\n====>>>Executing Before advice on method");
    }

    @Before("forDAOPackageNoGetterNoSetter()")
    public void performAPIAnalytics() {
        System.out.println("\n====>>>Peforming API Analytics on Method");
    }
}
