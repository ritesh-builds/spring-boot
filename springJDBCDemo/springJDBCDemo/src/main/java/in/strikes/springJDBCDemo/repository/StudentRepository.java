package in.strikes.springJDBCDemo.repository;

import in.strikes.springJDBCDemo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Ritesh@8219";

    private JdbcTemplate jdbcTemplate;

    private StudentRowMapper studentRowMapper = new StudentRowMapper();

    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // Connection connection = null;

    // method for create user..

    public void createStudent(Student student){
        String sql ="""
                    INSERT INTO students(name, email, age)
                    VALUES(?, ?, ?)   
                    """;

        int rowAffected = jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge());
        if(rowAffected == 1){
            System.out.println("Student created successfully");
        } else {
            System.out.println("Create Student failed.");
        }
    }

    public void updateStudent(Student student, long id){
        String sql = """
                        UPDATE students
                        SET name = ?,
                            email = ?,
                            age = ?
                        WHERE id = ?
                    """;


        int rowAffected = jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge(), id);

        if(rowAffected == 1){
            System.out.println("Update operation Successful.");
        } else {
            System.out.println("Updation Operation failed.");
        }
    }

    public void deleteStudent(Long id){
        String sql = """
                DELETE FROM students WHERE id = ?
                """;

        int rowAffected = jdbcTemplate.update(sql, id);

        if(rowAffected == 1){
            System.out.println("DELETE operation Successful.");
        } else {
            System.out.println("DELETION Operation failed.");
        }
    }

    public Student getStudentById(Long id){
        String sql = """
                SELECT id, email, name, age 
                FROM students WHERE id = ?
                """;
        return jdbcTemplate.queryForObject(sql, studentRowMapper, id);
    }

    public List<Student> getStudent(){
        String sql = """
                        SELECT id, name, email, age
                        FROM students
                    """;

        List<Student> students = jdbcTemplate.query(sql, studentRowMapper);
        return students;
    }
}
