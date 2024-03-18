package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Course;
import com.awambeng.fullstackcrudapp.models.Student;
import com.awambeng.fullstackcrudapp.models.StudentCourse;
import com.awambeng.fullstackcrudapp.repositories.CourseRepository;
import com.awambeng.fullstackcrudapp.repositories.StudentCourseRepository;
import com.awambeng.fullstackcrudapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentCourseImpl implements StudentCourseService{
    
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    
    @Override
    public List<StudentCourse> getAllStudentCourses(){
        return studentCourseRepository.findAll();
    }

    @Override
    public StudentCourse saveStudentCourse(long studentId, long courseId, StudentCourse studentCourse) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));

        studentCourse.setStudent(student.getId());
        studentCourse.setCourse(course.getId());

        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public StudentCourse getStudentCourseById(long id){
        return studentCourseRepository.findById(id).get();
    }

    @Override
    public String deleteStudentCourseById(long id){
        try{
            studentCourseRepository.findById(id).get();
            studentCourseRepository.deleteById(id);
            return "StudentCourse deleted successfully";
        }catch (Exception e){
            return "StudentCourse not found";
        }
    }

    @Override
    public StudentCourse updateStudentCourseById(long id, StudentCourse studentCourse){
        StudentCourse existingStudentCourse = studentCourseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StudentCourse not found with ID: " + id));

        existingStudentCourse.setStudent(studentCourse.getStudent());
        existingStudentCourse.setCourse(studentCourse.getCourse());
        existingStudentCourse.setEnrollDate(studentCourse.getEnrollDate());

        return studentCourseRepository.save(existingStudentCourse);
    }
}
