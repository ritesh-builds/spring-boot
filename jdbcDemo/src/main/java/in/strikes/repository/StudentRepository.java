package in.strikes.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import in.strikes.model.Student;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Ritesh@8219";
    // Connection connection = null;

    // method for create user..

    public void createStudent(Student student){
        String sql ="""
                    INSERT INTO students(name, email, age)
                    VALUES(?, ?, ?)   
                    """;

        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            
            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 1){
                System.out.println("Student created successfully");
            } else {
                System.out.println("Create Student failed.");
            }

            // Statement statement = connection.createStatement();
            
            // String sql = "Insert into students(name, email, age)"
            //              +"VALUE('Radhika', 'radhika@gmail.com', 21) ";

            // String sql = """
            //         INSERT INTO students(name, email, age)
            //         VALUES('%s', '%s', '%d')
            //         """.formatted(student.getName(), 
            //         student.getEmail(), 
            //         student.getAge()
            //     );

            // int result = statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.getMessage();

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
        try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(3, student.getId());

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 1){
                System.out.println("Update operation Successful.");
            } else {
                System.out.println("Updation Operation failed.");
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.getMessage();
        }
    }

    public void deleteStudent(Long id){
        String sql = """
                DELETE FROM students WHERE id = ?
                """;

         try(
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, id);
            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 1){
                System.out.println("DELETE operation Successful.");
            } else {
                System.out.println("DELETION Operation failed.");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.getMessage();
        }
    }

    public void getStudentById(Long id){
        String sql = """
                SELECT id, email, name, age 
                FROM students WHERE id = 1
                """;
        try(
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setLong(1, id);

            try (
                ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                resultSet.next();
                Student student = mapRow(resultSet);
                System.out.println(student);
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.getMessage();
        }
    }

    public void getStudent(){
        String sql = """
                        SELECT name, email, age 
                        FROM students
                    """;
                 try(
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                List<Student> studentList = new  ArrayList<>();
                while (resultSet.next()) {
                    Student student = mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.getMessage();
        }
    }

    public void completeCRUD(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            
            String sql = "SELECT name, email, age, id FROM students WHERE id = 1";

            boolean result = statement.execute(sql);

            if(result){
                ResultSet resultSet = statement.getResultSet();
            } else {
                int rowAffected = statement.getUpdateCount();
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setEmail(resultSet.getString("email"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }

}


// INSERT INTO students (...) VALUES (...);

// SELECT * FROM students;

// UPDATE students
// SET age = 20
// WHERE id = 1;

// DELETE FROM students
// WHERE id = 1;