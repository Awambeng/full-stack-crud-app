package com.awambeng.fullstackcrudapp.controllers;

import com.awambeng.fullstackcrudapp.models.Student;
import com.awambeng.fullstackcrudapp.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id) {
        String result = studentService.deleteStudentById(id);
        if (result.equals("Student deleted successfully")) {
            return ResponseEntity.ok(result);  // Return 200 OK with success message
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudentById(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);  // Return 200 OK with the updated student entity
        } else {
            return ResponseEntity.notFound().build();  // Return 404 Not Found if student is not
        }
    }
}
