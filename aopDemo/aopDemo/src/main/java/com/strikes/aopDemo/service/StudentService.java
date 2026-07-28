package com.strikes.aopDemo.service;

import org.springframework.stereotype.Service;

import com.strikes.aopDemo.annotation.TrackExecutionTime;
import com.strikes.aopDemo.dto.Student;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "Creating New Student"
    )
    public Student createStudent(Student student){
        System.out.println("Student saved.");
//        throw new RuntimeException("Some error happened");
        return student;
    }

    @Override
    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Get Student Data"
    )
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // String s = "";
        System.out.println(s);
        return s;
    }
}
