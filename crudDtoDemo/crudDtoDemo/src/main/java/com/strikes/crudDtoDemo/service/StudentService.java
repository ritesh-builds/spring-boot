package com.strikes.crudDtoDemo.service;

import com.strikes.crudDtoDemo.dto.StudentRequestDTO;
import com.strikes.crudDtoDemo.dto.StudentResponseDTO;
import com.strikes.crudDtoDemo.entity.Student;
import com.strikes.crudDtoDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentReqDto) {
        Student student = responseDtoToEntity(studentReqDto);

        Student studentResponse = studentRepository.save(student);
        return entityToDto(studentResponse);
    }

    public Student getStudentById(Long id){
        Optional<Student> byId = studentRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    public boolean deleteStudentById(Long id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        } return false;
    }

    public Student updateStudent(Student studentReq, Long id){
        Student oldStudent = studentRepository.getById(id);

        if(oldStudent != null){
            oldStudent.setName(studentReq.getName());
            oldStudent.setId(studentReq.getId());
            oldStudent.setEmail(studentReq.getEmail());
            return studentRepository.save(oldStudent);
        }
        return null;
    }

    private Student responseDtoToEntity(StudentRequestDTO studentRequestDTO){
        Student student = new Student();

        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setRollNo(studentRequestDTO.getRolNo());
        student.setAge(studentRequestDTO.getAge());
        student.setSubject(studentRequestDTO.getSubject());
        student.setDeleted(false);

        return student;
    }

    private StudentResponseDTO entityToDto(Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setSubject(student.getSubject());
        studentResponseDTO.setRolNo(student.getRollNo());

        return studentResponseDTO;
    }
}
