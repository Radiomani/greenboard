package com.boyzcompany.unist.web;

import java.util.Collection;
import java.util.List;

import org.bson.codecs.CollectibleCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boyzcompany.unist.model.Employee;
import com.boyzcompany.unist.repository.EmployeeRepository;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeRepository.find(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employee;
        // return employeeRepository.add(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestParam(name = "id", required = true) String id,
            @RequestBody Employee employee) {
        return employeeRepository.replace(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@RequestParam(name = "id", required = true) String id) {
        return employeeRepository.delete(id);
    }
}
