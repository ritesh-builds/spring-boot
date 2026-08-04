package rog.strix.SpringDataJPAdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rog.strix.SpringDataJPAdemo.entity.Student;
import rog.strix.SpringDataJPAdemo.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student student = studentService.getStudentBuId(id);
        return ResponseEntity.ok(student);
    }
}
