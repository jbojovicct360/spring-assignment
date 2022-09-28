package com.jovan_bojovic.spring_assignment.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloLogger {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.jovan_bojovic.spring_assignment.controller..*)")
    public void loggetInit() {}

    @Around("loggetInit()")
    public Object logger(ProceedingJoinPoint joinPoint) {
        System.out.println("*****************************");
        System.out.println("Method " + joinPoint.getSignature().getName() + " started!");
        Object object = null;
        try {
            object = joinPoint.proceed();
            System.out.println("Method " + joinPoint.getSignature().getName() + " ended!");
        } catch (Throwable e) {
            System.out.println("Method " + joinPoint.getSignature().getName() + " has error!");
            System.out.println("Error message: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            System.out.println("*****************************");
        }
        return object;
    }

}
