package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.data.CompanyData;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/companies")
public class CompanyController {

    List<Company> allCompany = new CompanyData().getCompanies();

    @GetMapping
    public List<Company> getCompanyInformation(@RequestParam(name = "page" , required = false) Integer page, @RequestParam(name = "pageSize",required = false) Integer pageSize) {
        if(page != null && pageSize != null) {
            return this.allCompany.subList((page - 1) * pageSize, (page-1) * pageSize + pageSize);
        }
        return this.allCompany;
    }

    @GetMapping(path = "/{id}")
    public Company getCertainCompany(@PathVariable int id) {
        return this.allCompany.stream().filter(company -> company.getCompanyID() == id).collect(Collectors.toList()).get(0);
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
    public List<Company> addCompany(@RequestBody Company company) {
        List<Company> companies = new CompanyData().getCompanies();
        companies.add(company);
        return companies;
    }

    @PutMapping(path = "/{companyID}")
    public List<Company> updateCompanyInformation(@RequestBody Company company, @PathVariable int companyID) {
        List<Company> companies = new ArrayList<>(new CompanyData().getCompanies());
        for (Company currentCompany: companies) {
            if(currentCompany.getCompanyID() == companyID) {
                currentCompany.setEmployees(company.getEmployees());
            }
        }
        return companies;
    }

    @DeleteMapping(path = "/{companyID}")
    public List<Company> deleteAllEmployeesInCompany(@PathVariable int companyID) {
        List<Company> companies = new ArrayList<>(new CompanyData().getCompanies());
        for (Company currentCompany: companies) {
            if(currentCompany.getCompanyID() == companyID) {
                currentCompany.setEmployees(null);
                companies.remove(currentCompany);
                break;
            }
        }
        return companies;
    }
}
