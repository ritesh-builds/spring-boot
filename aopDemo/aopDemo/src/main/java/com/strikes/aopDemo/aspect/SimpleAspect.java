package com.strikes.aopDemo.aspect;

import com.strikes.aopDemo.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

    // @Before("execution(public String com.strikes.aopDemo.service.StudentService.getStudent(String))")
    // @Before("@annotation(jdk.jfr.TimeStamp)")
    // public void logBeforeMethod(){
    //     System.out.println("Method Intercepted.");
    // }

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                       TrackExecutionTime trackExecutionTime)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            String operation = trackExecutionTime.operation();
            if(operation.isBlank()){
                operation = joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();

            if(duration >= warningThreshold){
                System.out.println("SLOW OPERATION ALERT: " +
                        "Time taken by the method: " +
                        operation+" is about: "+duration+"ms.");
            } else System.out.println("Time taken by the method: "+operation+" is about: "+duration+"ms.");
        }
    }
}
