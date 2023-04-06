package com.boyzcompany.unist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.boyzcompany.unist.dal.EmployeeRepository;
import com.boyzcompany.unist.model.Employee;

@RestController
public class EmployeeController {

    int idCounter = 1;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addEmployee(@RequestBody Employee employee) {
        employee.setEmployeeId(String.valueOf(this.idCounter));
        this.idCounter++;
        employeeRepository.save(employee);
        return employee.getEmployeeId();
    }

    @PutMapping("/employees/{id}")
    public String replaceEmployee(@PathVariable String id, @RequestBody Employee employee) {
        if (id.length() > 0) {
            employeeRepository.deleteById(id);
            employee.setEmployeeId(id);
            employeeRepository.save(employee);
            return id;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable String id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return id;
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
