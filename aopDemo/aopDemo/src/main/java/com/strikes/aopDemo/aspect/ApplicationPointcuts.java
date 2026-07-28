package com.strikes.aopDemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(com.strikes.aopDemo.controller..*)")
    public void controllerLayer(){
//        empty body
    }

    @Pointcut("within(com.strikes.aopDemo.service..*)")
    public void serviceLayer(){
//        empty body
    }

    @Pointcut("execution(public * * (..)")
    public void publicMethod(){
//        empty body
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod(){
        // empty body
    }

    @Pointcut("execution(* *.get* (..))")
    public void getterMethods(){
        // empty body
    }
}
