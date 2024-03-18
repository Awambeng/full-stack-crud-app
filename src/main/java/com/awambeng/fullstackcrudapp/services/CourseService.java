package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course saveCourse(Course course);
    Course getCourseById(long id);
    String deleteCourseById(long id);
    Course updateCourseById(long id, Course course);
}
