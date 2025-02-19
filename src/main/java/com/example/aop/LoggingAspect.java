package com.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.ProductService.*(..))")
    public void logBefore() {
        System.out.println("Before executing a service method...");
    }

    @After("execution(* com.example.service.ProductService.*(..))")
    public void logAfter() {
        System.out.println("After executing a service method...");
    }

    @Around("execution(* com.example.service.ProductService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before executing: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("After executing: " + joinPoint.getSignature().getName());
        return result;
    }
}

