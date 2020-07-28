package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1));
        employees.add(new Employee(2));
        employees.add(new Employee(3));
        return employees;
    }
}
