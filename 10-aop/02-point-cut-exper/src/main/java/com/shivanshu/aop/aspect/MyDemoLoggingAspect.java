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

    @Before("execution(public void com.shivanshu.aop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdviceSpecific() {
        System.out.println("======>>>> Executing @Before advice on addAccount() specific to AccountDAO");
    }

    @Before("execution(public void add*())")
    public void beforeAnyAddStartingMethod() {
        System.out.println("======>>>> Executing @Before advice on any add Starting method");
    }

    @Before("execution(* addAccountWithParam(com.shivanshu.aop.Account))")
    public void beforeAddAccSpecificArg() {
        System.out.println("======>>>> Executing @Before advice on specific arg");
    }

    @Before("execution(* addAccountWithParam(com.shivanshu.aop.Account, ..))")
    public void beforeAddAccTwoArg() {
        System.out.println("======>>>> Executing @Before advice on on or more than one arg");
    }

    @Before("execution(* addAccountWith*(..))")
    public void beforeAnyAddStartAnyNumParam() {
        System.out.println("======>>>> Executing @Before advice on method startung with addAccountWith having any number and type of arguments");
    }

    @Before("execution(* com.shivanshu.aop.dao.*.*(..))")
    public void beforeMethodInSpecificPackage() {
        System.out.println("======>>>> Executing @Before advice on method in specific package");
    }
}
