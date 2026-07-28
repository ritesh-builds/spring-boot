package com.strikes.aopDemo.service;

import com.strikes.aopDemo.dto.Student;

public interface StudentServiceInterface {

    Student createStudent(Student student);

    String getStudent(String s);
}
