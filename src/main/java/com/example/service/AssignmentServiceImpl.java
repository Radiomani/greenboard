package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Result;
import com.example.model.Student;
import com.example.model.Assignment;
import com.example.repositories.AssignmentRepository;
import com.example.repositories.CourseRepository;
import com.example.repositories.StudentRepository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;

@Service
public class AssignmentServiceImpl implements AssignmentService{
    
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Result<List<Assignment>> getAssignmentsByStudentID(String student_id){
        if (studentRepository.isStudentExist(student_id)) {
            Student student = studentRepository.getStudentByID(student_id);
            List<String> courses = student.getCoursesTaken();
            List<Assignment> ass = new ArrayList<>();
            for (String course : courses) {
                ass.addAll(assignmentRepository.getAssignmentsByCourseID(course));
            }
            return new Result<>(ass);
        } else {
            Result<List<Assignment>> result = new Result<>();
            result.notStudent();
            return result;
        }
    }

    @Override
    public Result<List<Assignment>> getAssignmentsByStudentIDandCourseID(String student_id, String course_id) {
        Result<List<Assignment>> result = new Result<>();
        if (studentRepository.isStudentExist(student_id)) {
            if (courseRepository.isCourseExist(course_id)) {
                Student student = studentRepository.getStudentByID(student_id);
                if (student.getCoursesTaken().contains(course_id)) {
                    return new Result<>(assignmentRepository.getAssignmentsByCourseID(course_id));
                } else {
                    result.noCourseAccess();
                    return result;
                }
            } else {
                result.notCourse();
                return result;
            }
        } else {
            result.notStudent();
            return result;             
        } 
    }

    @Override
    public Result<Assignment> getAssignmentByStudentIDandCourseIDandByAssingmentID(String student_id, String course_id, String assingment_id) {
        Result<Assignment> result = new Result<>();
        if (studentRepository.isStudentExist(student_id)) {
            if (courseRepository.isCourseExist(course_id)) {
                Student student = studentRepository.getStudentByID(student_id);
                if (student.getCoursesTaken().contains(course_id)) {
                    List<Assignment> asses =  assignmentRepository.getAssignmentsByCourseID(course_id);
                    boolean found = false;
                    Assignment ass = new Assignment();
                    for (Assignment a: asses) {
                        if (assingment_id == a.getAssignmentID()) {
                            ass = a;
                            found = true;
                            break;
                        }
                    }
                    if (found) return new Result<>(ass);
                    else {
                        result.notAssignment();
                        return result;
                    }
                } else {
                    result.noCourseAccess();
                    return result;
                }
            } else {
                result.notCourse();
                return result;
            }
        } else {
            result.notStudent();
            return result;             
        } 
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
