package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping
    public List<Employee> getAll(@RequestParam(name = "page" , required = false) Integer page, @RequestParam(name = "pageSize",required = false) Integer pageSize, @RequestParam(name =  "gender", required = false) String gender) {
        List<Employee> employees = new ArrayList<>();
        List<Employee> certainEmployees = new ArrayList<>();
        employees.add(new Employee(1, "female"));
        employees.add(new Employee(2, "female"));
        employees.add(new Employee(3, "female"));
        employees.add(new Employee(4, "female"));
        employees.add(new Employee(5, "male"));
        if(page != null && pageSize != null) {
            for(int index = 0; index < employees.size(); index++) {
                if(index >= (page - 1) && certainEmployees.size() <pageSize) {
                    certainEmployees.add(employees.get(index));
                }
            }
            return certainEmployees;
        }
        if(!gender.equals(null)) {
            for (Employee employee: employees) {
                if(employee.getGender().equals(gender)) {
                    certainEmployees.add(employee);
                }
            }
            return certainEmployees;
        }
        return employees;
    }

    @GetMapping(path = "/{id}")
    public Employee getCertainCompany(@PathVariable int id) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "female"));
        employees.add(new Employee(2, "female"));
        employees.add(new Employee(3, "female"));
        for (Employee employee: employees) {
            if(employee.getEmployeeID() == id) {
                return employee;
            }
        }
        return null;
    }


}
