package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Objects;

public class CompanyService {
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll(){
        return  companyRepository.findAll();
    }

    public Company findCompanyByID(int id) {
        return this.companyRepository.findById(id).orElse(null);
    }

    public List<Employee> findCompanyEmployeesByID(int companyID) {
        return Objects.requireNonNull(companyRepository.findById(companyID).orElse(null)).getEmployees();
    }

    public Page<Company> findRangeOfCompany(int page, int pageSize) {
        return this.companyRepository.findAll(PageRequest.of(page, pageSize));
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company deleteCompany(int companyID) {
        Company company = findCompanyByID(companyID);
        //
        companyRepository.deleteById(companyID);
        return company;
    }

    public Company update(int id, Company company) {
        Company updateCompany = this.companyRepository.findById(id).orElse(null);
        assert updateCompany != null;
        updateCompany.setCompanyName(company.getCompanyName());
        updateCompany.setEmployees(company.getEmployees());
        updateCompany.setEmployeesNumber(company.getEmployeesNumber());
        this.companyRepository.save(updateCompany);
        return updateCompany;
    }
}
