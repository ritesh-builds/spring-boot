package com.strikes.AopIntroductionDemo.service;

import com.strikes.AopIntroductionDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService {

    private LoggingDecorator loggingDecorator;

    public ExecutionTimeService(LoggingDecorator loggingDecorator){
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void createStudent(Student student) {
        long startTime = System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        long endTime = System.currentTimeMillis();

        System.out.println("Total time: "+ (endTime - startTime));
    }
}
