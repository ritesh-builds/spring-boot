package in.strikes;

import in.strikes.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World..");

        StudentRepository studentRepository = new StudentRepository();
        // studentRepository.createUser();
        // studentRepository.updateUser();
        // studentRepository.deleteUser();
        // studentRepository.readUsers();
        studentRepository.getUserById();
    }

    
}

// jdbc:mysql://localhost:3306/