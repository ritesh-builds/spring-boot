package com.strikes.aopDemo.service;

import org.springframework.stereotype.Service;

import com.strikes.aopDemo.dto.Student;

@Service
public class StudentService {

    public Student createStudent(Student student){
        System.out.println("Student saved.");
//        throw new RuntimeException("Some error happened");
        return student;
    }

    public String getStudent(String s){
        // String s = "";
        System.out.println(s);
        return s;
    }
}
