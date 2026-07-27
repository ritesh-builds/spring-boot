package in.strikes.CrudSpringBootDemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import in.strikes.CrudSpringBootDemo.dto.CreateStudentRequestDto;
import in.strikes.CrudSpringBootDemo.dto.CreateStudentResponseDTO;
import in.strikes.CrudSpringBootDemo.dto.UpdateStudentRequestDTO;
import in.strikes.CrudSpringBootDemo.dto.UpdateStudentResponseDTO;
import in.strikes.CrudSpringBootDemo.entity.Student;
import in.strikes.CrudSpringBootDemo.exception.DuplicateResourceException;
import in.strikes.CrudSpringBootDemo.exception.ResourceNotFoundException;
import in.strikes.CrudSpringBootDemo.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService( StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDto createStudentRequestDto){
        Student student = mapToEntity(createStudentRequestDto);
        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email "+ student.getEmail() +" already exists.");
        }
        Student savedStudent = studentRepository.save(student);
        return mapToResponseDto(savedStudent);
    }



    public CreateStudentResponseDTO getStudentById(Long id){
        Student studentResponse = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id +" not found" ));

        return mapToResponseDto(studentResponse);

    }

    public UpdateStudentResponseDTO updateStudent(UpdateStudentRequestDTO studentReq, Long id){
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id +" not found" ));

        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);

        return mapToUpdateDto(savedStudent);
    }



    public void  deleteStudentById(Long id){
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
        studentRepository.delete(studentToBeDeleted);
    }

    public List<CreateStudentResponseDTO> findAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
            return studentList
                    .stream()
                    .map(this::mapToResponseDto)
                    .toList();
    }

    public void deleteStudentSoftlyById(Long id) {
        Student studentToBeDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
        studentRepository.delete(studentToBeDeleted);

        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto) {
        Student student = new Student();

        student.setName(createStudentRequestDto.getName());
        student.setAge(createStudentRequestDto.getAge());
        student.setEmail(createStudentRequestDto.getEmail());
        student.setRollNo(createStudentRequestDto.getRollNo());
        student.setSubject(createStudentRequestDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDto(Student student){
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();

        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setEmail(student.getEmail());
        createStudentResponseDTO.setRollNo(student.getRollNo());
        createStudentResponseDTO.setSubject(student.getSubject());
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setMessage("Student "+student.getName()+" has been created");
        createStudentResponseDTO.setCreatedAt(LocalDateTime.now());
        createStudentResponseDTO.setUpdatedAt(LocalDateTime.now());

        return createStudentResponseDTO;
    }

    private UpdateStudentResponseDTO mapToUpdateDto(Student savedStudent) {
        UpdateStudentResponseDTO student = new UpdateStudentResponseDTO();

        student.setName(savedStudent.getName());
        student.setAge(savedStudent.getAge());
        student.setRollNo(savedStudent.getRollNo());
        student.setSubject(savedStudent.getSubject());
        student.setMessage("Student "+student.getName()+" has been updated");
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private boolean emailExists(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }
}

// 1. End point listen (/app/students POST).

// 2. Business Logic.

// Interact with DB to store the data.

// 4. Response back to client like postman/browser.