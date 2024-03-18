package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Student;
import com.awambeng.fullstackcrudapp.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher teacher);
    Teacher getTeacherById(long id);
    String deleteTeacherById(long id);
    Teacher updateTeacherById(long id, Teacher teacher);
}
