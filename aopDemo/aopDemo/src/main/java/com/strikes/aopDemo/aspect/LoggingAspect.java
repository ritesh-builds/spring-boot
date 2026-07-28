package com.strikes.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Pointcut("within(com.strikes.aopDemo.service..*)" +
//            " &&" +
//            " execution(public * * (..))")
//    public void logPublicServiceMethod() {
//        // empty body
//    }

    @Before("com.strikes.aopDemo.aspect.ApplicationPointcuts.publicServiceMethod")
    public void logBeforeMethod() {
        System.out.println("Method Intercepted.");
    }

    // @Before("execution(* com.strikes.aopDemo.service.StudentService.createStudent(..))")
    // @Before("within(com.strikes.aopDemo.service.StudentService)")
    // @Before("@annotation(jdk.jfr.TimeStamp)")
    // public void logBeforeMethod() {
    //     System.out.println("Method Intercepted.");
    // }
    
    // @Around("@annotation(jdk.jfr.TimeStamp)")
    // public void evaluateTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable{
    //     long startTime =    System.currentTimeMillis();

    //     joinPoint.proceed();
        
    //     long endTime = System.currentTimeMillis();

    //     System.out.println("Method Intercepted.");

    //     System.out.println("Total time: "+ (endTime - startTime));

    // }

//    @Before("execution(public " +
//            "com.strikes.aopDemo.dto " +
//            "com.strikes.aopDemo.service.StudentService.createStudent(com.strikes.aopDemo.dto))")
//    public void logBeforeMethod2() {
//        System.out.println("Method Intercepted.");
//    }
}
