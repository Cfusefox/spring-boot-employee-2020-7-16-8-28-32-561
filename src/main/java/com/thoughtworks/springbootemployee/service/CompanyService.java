package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class CompanyService {
    CompanyRepository companyRespository;

    public CompanyService(CompanyRepository companyRespository) {
        this.companyRespository = companyRespository;
    }

    public List<Company> findAll(){
        return  companyRespository.findAll();
    }

    public Company findCompanyByID(int id) {
        return this.companyRespository.findById(id).orElse(null);
    }

    public List<Employee> findCompanyEmployeesByID(int companyID) {
        return companyRespository.findById(companyID).orElse(null).getEmployees();
    }

    public Page<Company> findRangeOfCompany(int page, int pageSize) {
        return this.companyRespository.findAll(PageRequest.of(page, pageSize));
    }

    public Company addCompany(Company company) {
        companyRespository.save(company);
        return company;
    }

    public Company deleteCompany(int companyID) {
        Company company = findCompanyByID(companyID);
        companyRespository.deleteById(companyID);
        return company;
    }

    public Company update(int id, Company oocl) {
        Company updateCompany = this.companyRespository.findById(id).orElse(null);
        updateCompany.setCompanyName(oocl.getCompanyName());
        updateCompany.setEmployees(oocl.getEmployees());
        updateCompany.setEmployeesNumber(oocl.getEmployeesNumber());
        return updateCompany;
    }
}
