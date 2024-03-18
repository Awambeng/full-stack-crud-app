package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Course;

import java.util.List;

public interface StudentCourse {

    List<StudentCourse> getAllStudentCourses();
    StudentCourse saveStudentCourse(long id, StudentCourse studentCourse);
    StudentCourse getStudentCourseById(long id);
    String deleteStudentCourseById(long id);
    StudentCourse updateStudentCourseById(long id, StudentCourse studentCourse);
}
