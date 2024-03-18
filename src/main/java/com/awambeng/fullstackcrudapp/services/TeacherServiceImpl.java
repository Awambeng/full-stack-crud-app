package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Teacher;
import com.awambeng.fullstackcrudapp.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(long id){
        return teacherRepository.findById(id).get();
    }

    @Override
    public String deleteTeacherById(long id){
        try{
            teacherRepository.findById(id).get();
            teacherRepository.deleteById(id);
            return "Teacher deleted successfully";
        }catch (Exception e){
            return "Teacher not found";
        }
    }

    @Override
    public Teacher updateTeacherById(long id, Teacher teacher){
        Teacher existingTeacher = teacherRepository.findById(id).get();
        existingTeacher.setName(teacher.getName());
        existingTeacher.setSurname(teacher.getSurname());
        existingTeacher.setGender(teacher.getGender());
        existingTeacher.setDateOfBirth(teacher.getDateOfBirth());
        existingTeacher.setPhoneNumber(teacher.getPhoneNumber());
        return teacherRepository.save(existingTeacher);
    }
}
