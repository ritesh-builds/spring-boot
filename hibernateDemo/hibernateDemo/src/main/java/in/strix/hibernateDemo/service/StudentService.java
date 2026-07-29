package in.strix.hibernateDemo.service;

import java.util.List;

import in.strix.hibernateDemo.model.Student;
import in.strix.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student studentReq, Long id) {
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
