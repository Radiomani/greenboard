package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Result;
import com.example.model.Task;
import com.example.repositories.StudentRepository;
import com.example.repositories.TaskRepository;
import com.mongodb.internal.connection.Connection.PinningMode;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.TaskUtils;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Result<List<Task>> getTasksByStudentID(String student_id) {
        if (studentRepository.isStudentExist(student_id)) {
            return new Result<>(taskRepository.getTasksByStudentID(student_id));
        } else {
            Result<List<Task>> result = new Result<>();
            result.notStudent();
            return result;             
        } 
    }

    @Override
    public Result<Task> getTaskByStudentIDandTaskID(String student_id, String task_id) {
        if (studentRepository.isStudentExist(student_id)) {
            List<Task> tasks = taskRepository.getTasksByStudentID(student_id);
            Task task = new Task();
            boolean found = false;
            for (Task t : tasks) {
                if (task_id == t.getTaskName()) {
                    task = t;
                    found = true;
                }
            }
            if (found) {
                return new Result<>(task);
            } else {
                Result<Task> result = new Result<>();
                result.notTask();
                return result;  
            }
        } else {
            Result<Task> result = new Result<>();
            result.notStudent();
            return result;             
        } 
    }
    
    @Override
    public Result<Task> setTaskByStudentID(String student_id, Task task) {
        if (studentRepository.isStudentExist(student_id)) {
            task.setStudentID(student_id);
            return new Result<>(taskRepository.setTask(task));
        } else {
            Result<Task> result = new Result<>();
            result.notStudent();
            return result;             
        } 
    }

    @Override
    public Result<Task> updateTaskByStudentIDandTaskID(String student_id, String task_id, Task task) {
        if (studentRepository.isStudentExist(student_id)) {
            if (taskRepository.isTaskExistByTaskID(task_id)) {
                task.setStudentID(student_id);
                task.setTask_id(task_id);
                return new Result<>(taskRepository.updateTasksByTaskID(student_id, task_id, task));
            } else {
                Result<Task> result = new Result<>();
                result.notTask();
                return result;
            }
        } else {
            Result<Task> result = new Result<>();
            result.notStudent();
            return result;             
        } 
    }

    /*public String deleteTaskByStudentIDandTaskID(String student_id, String task_id) {
        return deleteTaskByStudentIDandTaskID(student_id, task_id);
    }*/
}
