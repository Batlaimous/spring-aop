package com.besho.aopdemo.aspect;

import com.besho.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    // this is where we add all of our related advice for logging


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
    @Before("com.besho.aopdemo.aspect.MyAopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println(" \n==========>>>>>>  Executing Before advice on addAccount");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println( "The method signature is:   ...... " + methodSignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();
        // loop thru args
        for (Object arg : args) {
            System.out.println("the arg value is: ......"+arg);
            if (arg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("Account Name  : " + theAccount.getName());
                System.out.println("Account Level : " + theAccount.getLevel());
            }
        }


    }

}
