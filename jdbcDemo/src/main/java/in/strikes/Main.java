package in.strikes;

import in.strikes.model.Student;
import in.strikes.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World..");

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.createStudent(new Student("Jiya", "jiya@gmail.com", 21));
        // studentRepository.updateStudent();
        // studentRepository.deleteStudent();
        // studentRepository.readStudents();
        // studentRepository.getStudentById();
    }

    
}

// jdbc:mysql://localhost:3306/