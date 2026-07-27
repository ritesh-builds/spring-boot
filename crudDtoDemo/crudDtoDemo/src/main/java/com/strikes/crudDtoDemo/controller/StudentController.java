package com.strikes.crudDtoDemo.controller;

import com.strikes.crudDtoDemo.dto.StudentRequestDTO;
import com.strikes.crudDtoDemo.dto.StudentResponseDTO;
import com.strikes.crudDtoDemo.entity.Student;
import com.strikes.crudDtoDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // create
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO createdStudent = studentService.createStudent(studentRequestDTO);
        if(createdStudent == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        boolean bool = studentService.deleteStudentById(id);
        if(bool == true){
            return ResponseEntity.status(HttpStatus.OK).body("Student with id: "+id+"successfully deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id: "+id+"not found");
    }
    // update
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id){
        Student studentRes = studentService.updateStudent(student, id);
        if(studentRes == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentRes);
    }
    // get
    @GetMapping("get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentRes = studentService.getStudentById(id);
        if(studentRes == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentRes);
    }



}
