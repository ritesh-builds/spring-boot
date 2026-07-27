package in.strikes.controller;

import in.strikes.entity.Student;
import in.strikes.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentRes = studentService.getStudent(id);
        if(studentRes == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        if(allStudents == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(allStudents);
    }

}
