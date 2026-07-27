package in.strikes.CrudSpringBootDemo.controller;

import in.strikes.CrudSpringBootDemo.dto.CreateStudentRequestDto;
import in.strikes.CrudSpringBootDemo.dto.CreateStudentResponseDTO;
import in.strikes.CrudSpringBootDemo.dto.UpdateStudentRequestDTO;
import in.strikes.CrudSpringBootDemo.dto.UpdateStudentResponseDTO;
import in.strikes.CrudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDto createStudentRequestDto){
        CreateStudentResponseDTO createdStudent = studentService.createStudent(createStudentRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudent(@PathVariable Long id){
        CreateStudentResponseDTO studentRes = studentService.getStudentById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentRes);
    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDTO> updateStudentDetails(@RequestParam Long id,
                                                                                 @RequestBody UpdateStudentRequestDTO studentReq){
        UpdateStudentResponseDTO updatedStudent = studentService.updateStudent(studentReq, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedStudent);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudentDetails(@RequestParam Long id){
       studentService.deleteStudentById(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudents(){
        List<CreateStudentResponseDTO> allStudent = studentService.findAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(allStudent);
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftlyById(@RequestParam Long id){
        studentService.deleteStudentSoftlyById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
