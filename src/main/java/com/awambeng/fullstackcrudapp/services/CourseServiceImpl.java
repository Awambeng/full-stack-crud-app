package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Course;
import com.awambeng.fullstackcrudapp.repositories.CourseRepository;
import com.awambeng.fullstackcrudapp.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(long id, Course course) {
        return teacherRepository.findById(id).map(teacher -> {
            course.setTeacher(teacher);
            return courseRepository.save(course);
        }).orElse(null);
    }

    @Override
    public Course getCourseById(long id){
        return courseRepository.findById(id).get();
    }

    @Override
    public String deleteCourseById(long id){
        try{
            courseRepository.findById(id).get();
            courseRepository.deleteById(id);
            return "Course deleted successfully";
        }catch (Exception e){
            return "Course not found";
        }
    }

    @Override
    public Course updateCourseById(long id, Course course){
        Course existingCourse = courseRepository.findById(id).get();
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setCourseCredit(course.getCourseCredit());
        existingCourse.setStartDate(course.getStartDate());
        existingCourse.setEndDate(course.getEndDate());
        existingCourse.setTeacher(course.getTeacher());

        return courseRepository.save(existingCourse);
    }
}
