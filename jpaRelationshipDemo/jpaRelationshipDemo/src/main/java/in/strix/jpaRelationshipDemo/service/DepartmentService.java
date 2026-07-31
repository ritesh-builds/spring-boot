package in.strix.jpaRelationshipDemo.service;

import in.strix.jpaRelationshipDemo.model.Department;
import in.strix.jpaRelationshipDemo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }
}
