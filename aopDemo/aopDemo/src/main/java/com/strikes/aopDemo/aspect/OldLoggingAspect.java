package com.strikes.aopDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.strikes.aopDemo.dto.Student;

@Component
@Aspect
public class OldLoggingAspect {

//     @Before("execution(String com.strikes.aopDemo.service.StudentService.createStudent())")
//     public void logBeforeMethod(JoinPoint joinPoint){

//         // Object[] arr = joinPoint.getArgs();   

//         System.out.println("Student is going to be saved...");

//        boolean allowed = false;
//        if(!allowed){
//            throw new RuntimeException("Method execution not allowed");
//        }
// }

//    @AfterReturning(
//        value = "execution(" +
//                "* com.strikes.aopDemo.service.StudentService" +
//                ".createStudent(..))",
//        returning = "result"
//    )
//    public void logAfterReturningMethod(Student result){
//        result.setName("Ishika");
//        result.setAge(21);
//        System.out.println("Intercepted createStudent()");
//    }

//     @AfterThrowing(
//         value = "execution(* com.strikes.aopDemo.service.StudentService.createStudent(..))",
//             throwing = "exception"
//     )
//     public void logAfterThrowingMethod(Throwable exception){
//         System.out.println("Exception type: "+exception.getClass().getName());
//         System.out.println("Exception message: "+exception.getMessage());
//     }

//     @After(
//         value = "execution(* com.strikes.aopDemo.service.StudentService.createStudent(..))"       
//     )
//     public void logAfterMethod(){
//         System.out.println("logAfterMethod Executed.");
//     }

//     @Around(
//         value = "execution(* com.strikes.aopDemo.service.StudentService.createStudent(..))"       
//     )
//     public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
//         System.out.println("Starting: "+joinPoint.getSignature().getName());

//         try {
//             Object result = joinPoint.proceed();
//             System.out.println("Execution successful");
//             return result;

//         } catch (Exception e) {
//             System.out.println("Execution failed: " + e.getMessage());
//             throw e;

//         } finally {

//             System.out.println("Execution completed.");
//         }
//     }

//     @Around(
//         value = "execution(* com.strikes.aopDemo.service.StudentService.dummyMethod(..))"       
//     )
//     public Object logAroundMethod1(ProceedingJoinPoint joinPoint) throws Throwable{
//         Object[] arr = joinPoint.getArgs();
//         String originalString = (String) arr[0];
//         String modifiedString = originalString.toUpperCase();
//         Object[] modifiedArr = {
//             modifiedString
//         };
        
//         String returnType = (String) joinPoint.proceed(modifiedArr);
//         returnType = returnType + " String Intercepted";
//         return returnType;
//     }
}

