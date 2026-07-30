package in.strix.hibernateInternals.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import in.strix.hibernateInternals.model.Student;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }

    public Student findById(long id) {
        final Student student = entityManager.find(Student.class, id);
        return student;
    }

    public void remove(Student student) {
        entityManager.remove(student);
    }
}
