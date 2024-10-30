package com.besho.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class MyAopExpressions {
    // point cut declaration to reuse it at any place
    @Pointcut("execution(* com.besho.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.besho.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.besho.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !getter() && !setter()")
    public void forDaoPackagenoGetterSetter() {}
}
