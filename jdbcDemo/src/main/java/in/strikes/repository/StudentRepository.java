package in.strikes.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.strikes.model.Student;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Ritesh@8219";

    // method for create user..

    public void createUser(){
         try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            
            String sql = "Insert into students(name, email, age)"
                         +"VALUE('Radhika', 'radhika@gmail.com', 21) ";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Create operation Successful.");
            } else {
                System.out.println("Create Operation failed.");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public void updateUser(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            
            String sql = "UPDATE students SET age=20 "+
                        "WHERE id=1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Update operation Successful.");
            } else {
                System.out.println("Updation Operation failed.");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public void deleteUser(){
         try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            
            String sql = "DELETE FROM students WHERE id=1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("DELETE operation Successful.");
            } else {
                System.out.println("DELETION Operation failed.");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public void getUserById(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            
            String sql = "SELECT id, email, name, age FROM students WHERE id = 1";

            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            Student student = mapRow(resultSet);
            System.out.println(student);

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public void readUsers() {
    try {
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

        while(resultSet.next()) {
            System.out.println(resultSet.getLong("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getInt("age"));
        }

        connection.close();

    } catch (SQLException e) {
        e.printStackTrace();
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