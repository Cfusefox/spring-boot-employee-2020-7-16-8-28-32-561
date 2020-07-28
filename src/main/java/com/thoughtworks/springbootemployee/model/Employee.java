package com.thoughtworks.springbootemployee.model;

public class Employee {
    private int employeeID;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee(int employeeID, String gender) {
        this.employeeID = employeeID;
        this.gender = gender;
    }

    public Employee() {

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
