package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.model.Assignment;
import com.example.repositories.AssignmentRepository;
import com.example.repositories.StudentRepository;
import com.mongodb.client.result.UpdateResult;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Service
public class AssignmentServiceImpl implements AssignmentService{
    
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<Assignment> getAssignmentsByStudentID(String student_id){
        Student student = studentRepository.getStudentByID();
        List<String> courses = student.getCoursesTaken();
        List<Assignment> ass = new ArrayList<>();
        for (String course : courses) {
            ass.addAll(assignmentRepository.getAssignmentsByCourseID(course));
        }
        return ass;
    }

    @Override
    public List<Assignment> getAssignmentsByStudentIDandCourseID(String student_id, String course_id) {
        //Student student = studentRepository.getStudentByID();
        //List<String> courses = student.getCoursesTaken();
        return assignmentRepository.getAssignmentsByCourseID(course_id);
    }

    @Override
    public Optional<Assignment> getAssignmentByStudentIDandCourseIDandByAssingmentID(String student_id, String course_id, String assingment_id) {
        //Student student = studentRepository.getStudentByID();
        //List<String> courses = student.getCoursesTaken();
        List<Assignment> asses =  assignmentRepository.getAssignmentsByCourseID(course_id);
        boolean found = false;
        Assignment ass;
        for (Assignment a: asses) {
            if (assingment_id == a.getAssignmentID()) {
                ass = a;
                found = true;
                break;
            }
        }
        if (found) return Optional.of(ass);
        else return Optional.empty();
    }


    /* 
    
    @Override
    public String save(Assignment assignment){
        assignment.setAssignmentId(getMaxId() + 1);
        return assignmentRepository.save(assignment).getId();
    }
    
    @Override
    public List<Assignment> getAssignment(){
        return assignmentRepository.findAll();
    }

    @Override
    public Optional<Assignment> getAssignmentById(int id) {
        Query query = new Query(Criteria.where("assignment_id").is(id));
        Assignment assignment = mongoTemplate.findOne(query, Assignment.class);
        if(assignment == null) {
            return Optional.empty();
        }
        return Optional.of(assignment);
    }

    @Override
    public Optional<Assignment> getAssignmentById(String id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public UpdateResult updateAssignmentById(int id, Assignment updated_assignment) {
        Query query = new Query(Criteria.where("assignment_id").is(id));
        Update update = new Update()
        .set("gender", updated_assignment.getGender())
        .set("age", updated_assignment.getAge())
        .set("occupation", updated_assignment.getOccupation())
        .set("zip_code", updated_assignment.getZip_code());
        UpdateResult result = mongoTemplate.updateFirst(query, update, Assignment.class);
        return result;
    }

    @Override
    public int getMaxId() {
        Query query = new Query();
        query.limit(1).with(Sort.by(Sort.Direction.DESC, "assignment_id"));
        return mongoTemplate.find(query, Assignment.class).get(0).getAssignment_id();
    } */
}
