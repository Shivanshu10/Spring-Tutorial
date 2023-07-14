package com.shivanshu.aop.aspect;

import com.shivanshu.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Before("com.shivanshu.aop.aspect.AopExpression.forDAOPackageNoGetterNoSetter()")
    public void beforeAnyMethodInDAOPackage(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n====>>>Executing Before advice on method: "+methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object arg: args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name: "+account.getName());
                System.out.println("account level: "+account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.shivanshu.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturnFindAccount(JoinPoint jointPoint, List<Account> result) {
        String method = jointPoint.getSignature().toShortString();
        System.out.println("After return on method: "+method);

        System.out.println("Method result before change: "+result);

        if (result.isEmpty()==false) {
            Account account = result.get(0);

            account.setName("Shivanshu Mishra");
            account.setLevel("ADMIN");
        }

        System.out.println("Method result after change: "+result);
    }
}
