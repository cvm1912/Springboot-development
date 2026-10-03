package in.strikes.controller;

import in.strikes.models.Student;
import in.strikes.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public void getStudentById(@PathVariable Long id) {
        studentService.getStudentById(id);
    }
}
