package com.shivanshu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {
    @Pointcut("execution(* com.shivanshu.aop.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(* com.shivanshu.aop.dao.*.get*(..))")
    public void forGetter() {}

    @Pointcut("execution(* com.shivanshu.aop.dao.*.set*(..))")
    public void forSetter() {}

    @Pointcut("forDAOPackage() && !(forGetter() || forSetter())")
    public void forDAOPackageNoGetterNoSetter() {}
}
