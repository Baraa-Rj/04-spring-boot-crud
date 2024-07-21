package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
@GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(
            new Student("Poornima", "Patel"),
            new Student("Mario", "Rossi"),
            new Student("Mary", "Smith")
        );
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        List<Student> students = List.of(
            new Student("Poornima", "Patel"),
            new Student("Mario", "Rossi"),
            new Student("Mary", "Smith")
        );
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }

}
