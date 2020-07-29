package com.thoughtworks.springbootemployee.data;

import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    List<Employee> employees = new ArrayList<>();

    public EmployeeData() {
        this.employees.add(new Employee(1, "female"));
        this.employees.add(new Employee(2, "female"));
        this.employees.add(new Employee(3, "female"));
        this.employees.add(new Employee(4, "male"));
        this.employees.add(new Employee(5, "male"));
    }

    public boolean addEmployee(Employee employee) {
        return this.employees.add(employee);
    }
}
