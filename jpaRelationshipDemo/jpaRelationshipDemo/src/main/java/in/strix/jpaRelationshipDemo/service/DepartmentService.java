package in.strix.jpaRelationshipDemo.service;

import in.strix.jpaRelationshipDemo.model.Department;
import in.strix.jpaRelationshipDemo.model.Student;
import in.strix.jpaRelationshipDemo.repository.DepartmentRepository;
import in.strix.jpaRelationshipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, String studentName) {
        Student student = new Student();
        student.setName(studentName);

        student.setDepartment(department);

        department.getStudents().add(student);

        studentRepository.save(student);
        departmentRepository.save(department);
    }
}
