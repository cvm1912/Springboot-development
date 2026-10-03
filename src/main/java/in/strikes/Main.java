package in.strikes;

import in.strikes.models.Student;
import in.strikes.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static void main() {
        System.out.println("Helo World");
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.completeCrud(new Student("shivam","shivam@gmail.com",12));


    }
}

