package com.besho.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advice for logging

    // point cut declaration to reuse it at any place
    @Pointcut("execution(* com.besho.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.besho.aopdemo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.besho.aopdemo.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !getter() && !setter()")
    private void forDaoPackagenoGetterSetter() {}
    // let's start with an @Before advice
    // pointcut expression language
    // public Modifier
    // void return type
    // for addAccount here it means as any call with this class will call this before advice AOP to run not in specific class
    // we can make it for special class inside special class by replace it with full path of the class like com.besho.aopdemo.dao.AccountDAO.addAccount()
    //********************* WILDCARDS *******************//
    // @Before("execution(public void add*())") this mean at any method start with "add" will execute
    // Modifier is optional ..... so you don't have to list it
    // @Before("execution(* processCreditCard*())") the first "*" is for return type and second one th know as any methos start with this word will execute this before it
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println(" \n==========>>>>>>  Executing Before advice on addAccount");
    }

    @After("forDaoPackagenoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println(" \n==========............................>>>>>>  performing api analytics ");
    }
}
