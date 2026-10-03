package in.strikes.service;

import in.strikes.models.Student;
import in.strikes.repository.StudentRepository;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.createUser(student);
    }

    public void updateStudent(Student student, Long id) {
        studentRepository.updateUser(student, id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteUser(id);
    }

    public void getStudentById(Long id) {
        studentRepository.getUserById(id);
    }
}
