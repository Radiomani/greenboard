package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Result;
import com.example.model.Student;
import com.example.repositories.StudentRepository;
import com.mongodb.client.result.UpdateResult;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Result<Student> save(Student student){
        try {
            String new_student_id = studentRepository.save(student).getId();
            if (studentRepository.isStudentExist(new_student_id)) {
                Student new_student = studentRepository.getStudentByID(new_student_id);
                return new Result<>(new_student);
            } else {
                Result<Student> result = new Result<>();
                result.noSaveSuccess();
                return result;
            }
        } catch (Exception e) {
            Result<Student> result = new Result<>();
            result.noSaveSuccess();
            return result;
        }
    }

    @Override
    public Result<Student> getStudentByID(String student_id) {
        if (studentRepository.isStudentExist(student_id)) {
            return new Result<>(studentRepository.getStudentByID(student_id));
        } else {
            Result<Student> result = new Result<>();
            result.notStudent();
            return result;             
        } 
    }
    @Override
    public Result<Student> updateStudentByID(String student_id, Student new_student) {
        if (studentRepository.isStudentExist(student_id)) {
            return new Result<>(studentRepository.updateStudentByID(student_id,new_student));
        } else {
            Result<Student> result = new Result<>();
            result.notStudent();
            return result;    
        }
    }
}
