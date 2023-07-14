package com.shivanshu.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.shivanshu.aop.aspect.AopExpression.forDAOPackageNoGetterNoSetter()")
    public void performAPIAnalytics() {
        System.out.println("\n====>>>Peforming API Analytics on Method");
    }
}
