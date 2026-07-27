package com.strikes.AopIntroductionDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strikes.AopIntroductionDemo.dto.Student;
import com.strikes.AopIntroductionDemo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("done");
    }
}
