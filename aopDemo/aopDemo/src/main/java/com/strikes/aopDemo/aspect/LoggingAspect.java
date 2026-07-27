package com.strikes.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("within(com.strikes.aopDemo.service.StudentService)")
    public void logBeforeMethod() {
        System.out.println("Method Intercepted.");
    }

//    @Before("execution(public " +
//            "com.strikes.aopDemo.dto " +
//            "com.strikes.aopDemo.service.StudentService.createStudent(com.strikes.aopDemo.dto))")
//    public void logBeforeMethod2() {
//        System.out.println("Method Intercepted.");
//    }
}
