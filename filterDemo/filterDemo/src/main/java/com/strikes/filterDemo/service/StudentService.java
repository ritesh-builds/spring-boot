package com.strikes.filterDemo.service;

import com.strikes.filterDemo.dto.Student;
import com.strikes.filterDemo.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentResponseDTO responseDTO = new StudentResponseDTO();

    public StudentResponseDTO createStudent(Student student){

        responseDTO.setName(student.getName());
        responseDTO.setMessage("User Saved Successfully.");

        return responseDTO;
    }
}
