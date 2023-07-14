package com.shivanshu.aop.aspect;

import com.shivanshu.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterThrowing(
            pointcut = "execution(* com.shivanshu.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint jointPoint, Throwable theExc) {
        String method = jointPoint.getSignature().toShortString();
        System.out.println("After throwing on method: "+method);

        System.out.println("Exception: "+theExc);
    }

    @After("execution(* com.shivanshu.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("After after(finally) on method: "+method);
    }

    @Around("execution(* com.shivanshu.aop.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Around on method: "+method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception err) {
            System.out.println(err.getMessage());

            result = "Heli on the way";
        }
        /*
        catch (Exception err) {
            System.out.println(err.getMessage());

            throw err;
        }
        */
        long end = System.currentTimeMillis();

        long duration = (end - begin)/1000L;
        System.out.println("Duration: "+duration);
        return result;
    }
}
