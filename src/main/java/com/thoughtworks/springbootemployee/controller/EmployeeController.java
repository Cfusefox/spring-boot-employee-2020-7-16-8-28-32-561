package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.data.EmployeeData;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    List<Employee> allEmployee = new EmployeeData().getEmployees();

    @GetMapping
    public List<Employee> getEmployeesInformation(@RequestParam(name = "page" , required = false) Integer page,
                                 @RequestParam(name = "pageSize",required = false) Integer pageSize,
                                 @RequestParam(name =  "gender", required = false) String gender) {
        List<Employee> certainEmployees = allEmployee;
        if(gender != null) {
            certainEmployees = certainEmployees.stream().filter(certainEmployee -> certainEmployee.getGender().equals(gender)).collect(Collectors.toList());
        }
        if(page != null && pageSize != null) {
            certainEmployees = certainEmployees.stream().skip(page - 1).limit(pageSize).collect(Collectors.toList());
        }
        return certainEmployees;
    }

    @GetMapping(path = "/{id}")
    public Employee getCertainEmployee(@PathVariable int id) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Zach", 18, "male", 1000));
        employees.add(new Employee(2, "York", 18, "male", 1000));
        employees.add(new Employee(3, "Karen", 18, "female", 1000));
        for (Employee employee: employees) {
            if(employee.getEmployeeID() == id) {
                return employee;
            }
        }
        return null;
    }

    @PostMapping
    public boolean addEmployee(@RequestBody Employee employee) {
        List<Employee> employees = new ArrayList<>();
        return employees.add(employee);
    }

    @PutMapping(path = "/{employeeID}")
    public Boolean updateEmployeeInformation(@RequestBody Employee employee, @PathVariable int employeeID) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Zach", 18, "male", 1000));
        employees.add(new Employee(2, "York", 18, "male", 1000));
        employees.add(new Employee(3, "Karen", 18, "female", 1000));
        for (Employee currentEmployee: employees) {
            if(currentEmployee.getEmployeeID() == employeeID) {
                currentEmployee.setGender(employee.getGender());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping(path = "/{employeeID}")
    public Boolean deleteEmployee(@PathVariable int employeeID) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Zach", 18, "male", 1000));
        employees.add(new Employee(2, "York", 18, "male", 1000));
        employees.add(new Employee(3, "Karen", 18, "female", 1000));
        for (Employee currentEmployee: employees) {
            if(currentEmployee.getEmployeeID() == employeeID) {
                employees.remove(currentEmployee);
                return true;
            }
        }
        return false;
    }
}
