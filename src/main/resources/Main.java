package in.strikes;

import in.strikes.controller.StudentController;
import in.strikes.models.Student;
import in.strikes.repository.StudentRepository;
import in.strikes.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        StudentController studentController = new StudentController(studentService);

        // Create
        studentController.createStudent(new Student("Shivam", "shivam@gmail.com", 24));

        // Get by ID
        studentController.getStudentById(1L);

        // Update
        studentController.updateStudent(new Student("Shivam Raj", "shivamraj@gmail.com", 25), 1L);

        // Delete
        studentController.deleteStudent(1L);
    }
}
