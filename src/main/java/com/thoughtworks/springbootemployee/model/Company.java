package com.thoughtworks.springbootemployee.model;

import java.util.List;

public class Company {
    public Company() {
    }

    private int companyID;
    private String companyName;
    private int employeesNumber;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    public Company(int companyID, String companyName, int employeesNumber, List<Employee> employees) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
    }

    public void setEmployeeNumber() {
        this.employeesNumber = employees.size();
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}
