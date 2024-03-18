package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.StudentCourse;

import java.util.List;

public interface StudentCourseService {

    List<StudentCourse> getAllStudentCourses();
    StudentCourse saveStudentCourse(long studentId, long courseId, StudentCourse studentCourse);
    StudentCourse getStudentCourseById(long id);
    String deleteStudentCourseById(long id);
    StudentCourse updateStudentCourseById(long id, StudentCourse studentCourse);
}
