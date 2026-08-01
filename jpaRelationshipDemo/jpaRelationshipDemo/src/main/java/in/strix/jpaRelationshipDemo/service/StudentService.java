package in.strix.jpaRelationshipDemo.service;

import in.strix.jpaRelationshipDemo.model.Department;
import in.strix.jpaRelationshipDemo.model.Student;
import in.strix.jpaRelationshipDemo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import in.strix.jpaRelationshipDemo.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private DepartmentRepository departmentRepository;
    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long id) {
        Department department = departmentRepository.getDepartmentById(id);
        student.setDepartment(department);
        department.getStudents().add(student);

        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName) {
        Department department = new Department();
        department.setName(deptName);

        student.setDepartment(department);
        department.getStudents().add(student);

        departmentRepository.save(department);

        studentRepository.save(student);
    }
}
