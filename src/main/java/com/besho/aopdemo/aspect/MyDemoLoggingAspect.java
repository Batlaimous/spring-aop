package com.besho.aopdemo.aspect;

import com.besho.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    // add a new advice for #Around
    @Around("execution(* com.besho.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {
        // print out method we Are advising on
        String method = pjp.getSignature().toShortString();
        System.out.println("\n-----<<<AROUND AROUND AROUND " +
                " Executing ..................... on Method  " + method);
        // get begin timestamp
long startTime = System.currentTimeMillis();
        // now, let's execute the method
        Object result = null;
        try{
           result = pjp.proceed();
        }catch (Exception exc){
            // log the exception
            System.out.println(exc.getMessage());

            // give user a custom message
//result = "Major Accident! But no Worries, we are on the way to pick you up.......";
// rethrow the exception
            throw exc;
        }


        // get end timestamp
long endTime = System.currentTimeMillis();
        // compute duration and display it
        long executionTime = endTime - startTime;
        System.out.println(" DURATION : " + executionTime /1000.0 + " seconds");
        return result;
    }
    // add a new advice for #AfterThrowing on the find account( param ) method
    @AfterThrowing(
            pointcut = "execution(* com.besho.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n-----<<<Throwing ERROR >>>>>------ Executing @AfterThrowing on method: " + method);
        // log the exception
        System.out.println("\n-----<<<the exception is : : " + theExc);
    }

    // this is where we add all of our related advice for logging

    // add a new advice for @AfterReturning on the findAccount method

    @AfterReturning(
            pointcut = "execution(* com.besho.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // print out which method we are advice on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n-----<<<>>>>>------ Executing @AfterReturning on method: " + method);

        // print out the results of method call
        System.out.println("\n-----<<< Result >>>>>------  " + result);

        // let's post-process the data .... let's modify it :-
        // convert the account names to all uppercase
        convertAcountNamesToUpperCase(result);
        System.out.println("\n-----<<< Upper Case Result >>>>>------  " + result);


    }

    private void convertAcountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount : result) {
            String theUpperAccountName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperAccountName);
        }
        // get the upperCase version of name

        // update the name on the account

    }

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
    @After("com.besho.aopdemo.aspect.MyAopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println(" \n==========>>>>>>  Executing AFTER AFTER AFTER  advice on addAccount");

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
