package in.strikes;

import in.strikes.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {
        System.out.println("Helo World");
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.getUserById();


    }
}

