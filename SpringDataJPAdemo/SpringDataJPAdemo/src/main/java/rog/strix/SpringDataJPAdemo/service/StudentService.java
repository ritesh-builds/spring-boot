package rog.strix.SpringDataJPAdemo.service;

import org.springframework.stereotype.Service;
import rog.strix.SpringDataJPAdemo.entity.Student;
import rog.strix.SpringDataJPAdemo.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentBuId(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.get();
    }
}
