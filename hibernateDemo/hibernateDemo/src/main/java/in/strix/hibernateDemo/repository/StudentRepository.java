package in.strix.hibernateDemo.repository;

import in.strix.hibernateDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // create
    public void save(Student student){
        entityManager.persist(student);
    }
    // update

    // read
    public Student findById(Long id){
        Student student = entityManager.find(Student.class, id);
        return student;
    }
    // delete
    public void remove(Student student){
        entityManager.remove(student);
    }
}
