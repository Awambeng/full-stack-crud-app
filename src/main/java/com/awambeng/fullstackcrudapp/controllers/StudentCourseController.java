package com.awambeng.fullstackcrudapp.controllers;

import com.awambeng.fullstackcrudapp.models.StudentCourse;
import com.awambeng.fullstackcrudapp.services.StudentCourseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-courses")
public class StudentCourseController {

    @Autowired
    private StudentCourseImpl studentCourseService;

    @GetMapping
    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseService.getAllStudentCourses();
    }

    @PostMapping
    public ResponseEntity<StudentCourse> saveStudentCourse(
            @PathVariable("studentId") long studentId,
            @PathVariable("courseId") long courseId,
            @RequestBody StudentCourse studentCourse) {
        StudentCourse savedStudentCourse = studentCourseService.saveStudentCourse(studentId, courseId, studentCourse);
        return ResponseEntity.ok(savedStudentCourse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourse> getStudentCourseById(@PathVariable("id") long id) {
        StudentCourse studentCourse = studentCourseService.getStudentCourseById(id);
        if (studentCourse != null) {
            return ResponseEntity.ok(studentCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentCourseById(@PathVariable("id") long id) {
        String result = studentCourseService.deleteStudentCourseById(id);
        if (result.equals("StudentCourse deleted successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentCourse> updateStudentCourseById(
            @PathVariable("id") long id,
            @RequestBody StudentCourse studentCourse) {
        StudentCourse updatedStudentCourse = studentCourseService.updateStudentCourseById(id, studentCourse);
        if (updatedStudentCourse != null) {
            return ResponseEntity.ok(updatedStudentCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
