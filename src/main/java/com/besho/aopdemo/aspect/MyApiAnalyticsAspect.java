package com.besho.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.besho.aopdemo.aspect.MyAopExpressions.forDaoPackagenoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println(" \n]]]]]...........//////..........[[/////]]  performing api analytics ");
    }
}
