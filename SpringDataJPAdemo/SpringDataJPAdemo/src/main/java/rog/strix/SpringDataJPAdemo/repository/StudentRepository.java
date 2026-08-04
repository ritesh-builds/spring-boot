package rog.strix.SpringDataJPAdemo.repository;

import rog.strix.SpringDataJPAdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
