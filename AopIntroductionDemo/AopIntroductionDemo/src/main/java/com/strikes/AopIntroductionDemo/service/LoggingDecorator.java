package com.strikes.AopIntroductionDemo.service;

import org.springframework.stereotype.Component;

import com.strikes.AopIntroductionDemo.dto.Student;

@Component
public class LoggingDecorator implements StudentService {

    private StudentServiceImpl studentServiceimpl;

    public LoggingDecorator(StudentServiceImpl studentServiceimpl){
        this.studentServiceimpl = studentServiceimpl;
    }

    @Override
    public void createStudent(Student student) {
        LoggingServiceUtil.logStart(
                "StudentServiceImpl", "createStudent");

        studentServiceimpl.createStudent(student);

        LoggingServiceUtil.logEnd(
                "StudentServiceImpl", "createStudent");
    }
}
