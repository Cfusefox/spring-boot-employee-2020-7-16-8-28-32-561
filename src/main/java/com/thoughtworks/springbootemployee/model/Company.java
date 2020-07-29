package com.thoughtworks.springbootemployee.model;

import java.util.List;

public class Company {
    public Company() {
    }

    private int companyID;
    private int employeeNumber;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    public Company(int companyID, List<Employee> employees) {
        this.companyID = companyID;
        this.employees = employees;
        this.employeeNumber = employees.size();
    }

    public void setEmployeeNumber() {
        this.employeeNumber = employees.size();
    }

    public int getCompanyID() {
        return companyID;
    }


}
