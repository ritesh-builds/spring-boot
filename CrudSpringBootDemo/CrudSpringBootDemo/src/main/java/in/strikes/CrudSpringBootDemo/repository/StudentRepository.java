package in.strikes.CrudSpringBootDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.strikes.CrudSpringBootDemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();

    Boolean existsByEmail(String emailId);
}


//  for new query...
//  findBy + fieldName + condition