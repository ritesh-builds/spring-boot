package in.strix.jpaRelationshipDemo.controller;

import in.strix.jpaRelationshipDemo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.strix.jpaRelationshipDemo.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @PathVariable Long deptId){
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("DONE");
    }
}
