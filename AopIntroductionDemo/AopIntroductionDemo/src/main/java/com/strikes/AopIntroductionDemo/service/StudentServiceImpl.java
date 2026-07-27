package com.strikes.AopIntroductionDemo.service;

import com.strikes.AopIntroductionDemo.dto.Student;
import com.strikes.AopIntroductionDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save();

    }
}
