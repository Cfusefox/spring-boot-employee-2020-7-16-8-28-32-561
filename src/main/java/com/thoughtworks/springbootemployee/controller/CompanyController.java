package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.data.CompanyData;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    @GetMapping
    public List<Company> getCompanyInformation(@RequestParam(name = "page" , required = false) Integer page, @RequestParam(name = "pageSize",required = false) Integer pageSize) {
        List<Company> companies = new ArrayList<>(new CompanyData().getCompanies());
        if(page != null && pageSize != null) {
            //todo bug
            return companies.subList((page - 1) * pageSize, (page-1) * pageSize + pageSize);
        }
        return companies;
    }

    @GetMapping(path = "/{id}")
    public Company getCertainCompany(@PathVariable int id) {
        List<Company> companies = new ArrayList<>(new CompanyData().getCompanies());
        for (Company company: companies) {
            if(company.getCompanyID() == id) {
                return company;
            }
        }
        return null;
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> getEmployeesInCompany(@PathVariable int id) {
        List<Company> companies = new ArrayList<>(new CompanyData().getCompanies());
        for (Company company: companies) {
            if(company.getCompanyID() == id) {
                return company.getEmployees();
            }
        }
        return null;
    }

    @PostMapping
    public Boolean addCompany(@RequestBody Company company) {
        List<Company> companies = new ArrayList<>();
        return companies.add(company);
    }

    @PutMapping(path = "/{companyID}")
    //todo post put return value
    public Boolean updateCompanyInformation(@RequestBody Company company, @PathVariable int companyID) {
        List<Company> companies = new ArrayList<>(new CompanyData().getCompanies());
        for (Company currentCompany: companies) {
            if(currentCompany.getCompanyID() == companyID) {
                currentCompany.setEmployees(company.getEmployees());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping(path = "/{companyID}")
    public Boolean deleteAllEmployeesInCompany(@PathVariable int companyID) {
        List<Company> companies = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "female"));
        companies.add(new Company(1,employees));
        for (Company currentCompany: companies) {
            if(currentCompany.getCompanyID() == companyID) {
                currentCompany.setEmployees(null);
                return true;
            }
        }
        return false;
    }
}
