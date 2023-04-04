package com.boyzcompany.unist.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.boyzcompany.unist.model.Employee;

@Service
public class EmployeeRepository {
    private Map<String, Employee> db = new HashMap<>();
    private int counter = 0;

    public Collection<Employee> findAll() {
        return db.values();
    }

    public Employee find(String id) {
        return db.get(id);
    }

    public Employee add(Employee employee) {
        counter++;
        return db.put(String.valueOf(counter), employee);
    }

    public Employee replace(String id, Employee employee) {
        return db.replace(id, employee);
    }

    public Employee delete(String id) {
        return db.remove(id);
    }
}
