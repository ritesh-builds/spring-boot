package in.strix.hibernateInternals.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import in.strix.hibernateInternals.model.Student;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }

    public void saveAll(List<Student> students){
        int counter = 0 ;
        for(Student student: students){
            entityManager.persist(student);
            counter++;
            if(counter % 100 == 0){
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    public Student findById(long id) {
        final Student student = entityManager.find(Student.class, id);
        return student;
    }

    public void remove(Student student) {
        entityManager.remove(student);
    }
}
