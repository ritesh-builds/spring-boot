package in.strix.hibernateInternals.service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import in.strix.hibernateInternals.model.Student;
import in.strix.hibernateInternals.repository.StudentRepository;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return null;
    }

    @Transactional
    public Student getStudentById(long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student studentReq, long id) {
        Student student1 = studentRepository.findById(id);
        if(student1 == null){
            throw new RuntimeException("Student not found.");
        }
        student1.setName(studentReq.getName());
        student1.setAge(studentReq.getAge());
        student1.setEmail(studentReq.getEmail());
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);

        if(student == null){
            throw new RuntimeException("Student not found.");
        }
        studentRepository.remove(student);
    }
}
