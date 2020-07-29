package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping
    public List<Employee> getEmployeesInformation(@RequestParam(name = "page" , required = false) Integer page,
                                 @RequestParam(name = "pageSize",required = false) Integer pageSize,
                                 @RequestParam(name =  "gender", required = false) String gender) {
        List<Employee> employees = new ArrayList<>();
        List<Employee> certainEmployees = new ArrayList<>();
        employees.add(new Employee(1, "Zach", 18, "male", 1000));
        employees.add(new Employee(2, "York", 18, "male", 1000));
        employees.add(new Employee(3, "Karen", 18, "female", 1000));
        if(page != null && pageSize != null) {
            for(int index = 0; index < employees.size(); index++) {
                if(index >= (page - 1) && certainEmployees.size() <pageSize) {
                    certainEmployees.add(employees.get(index));
                }
            }
            return certainEmployees;
        }
        if(gender != null) {
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
