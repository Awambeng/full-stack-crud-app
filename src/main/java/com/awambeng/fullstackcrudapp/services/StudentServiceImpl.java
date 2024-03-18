package com.awambeng.fullstackcrudapp.services;

import com.awambeng.fullstackcrudapp.models.Student;
import com.awambeng.fullstackcrudapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id){
        return studentRepository.findById(id).get();
    }

    @Override
    public String deleteStudentById(long id){
        try{
            studentRepository.findById(id).get();
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        }catch (Exception e){
            return "Student not found";
        }
    }

    @Override
    public Student updateStudentById(long id, Student student){
        Student existingStudent = studentRepository.findById(id).get();
        existingStudent.setName(student.getName());
        existingStudent.setSurname(student.getSurname());
        existingStudent.setGender(student.getGender());
        existingStudent.setDateOfBirth(student.getDateOfBirth());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        return studentRepository.save(existingStudent);
    }
}
