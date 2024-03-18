package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(long id);
    String deleteStudentById(long id);
    Student updateStudentById(long id, Student student);
}
