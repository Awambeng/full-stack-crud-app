package com.awambeng.fullstackcrudapp.controllers;

import com.awambeng.fullstackcrudapp.models.Teacher;
import com.awambeng.fullstackcrudapp.services.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getStudentById(@PathVariable long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return ResponseEntity.ok(savedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable long id) {
        String result = teacherService.deleteTeacherById(id);
        if (result.equals("Teacher deleted successfully")) {
            return ResponseEntity.ok(result);  // Return 200 OK with success message
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacherById(@PathVariable long id, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacherById(id, teacher);
        if (updatedTeacher != null) {
            return ResponseEntity.ok(updatedTeacher);  // Return 200 OK with the updated student entity
        } else {
            return ResponseEntity.notFound().build();  // Return 404 Not Found if student is not
        }
    }
}
