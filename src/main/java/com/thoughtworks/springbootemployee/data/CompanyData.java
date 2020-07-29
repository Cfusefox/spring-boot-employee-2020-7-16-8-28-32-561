package com.thoughtworks.springbootemployee.data;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyData {
    List<Company> companies = new ArrayList<>();

    public CompanyData() {
        companies.add(new Company(1, new ArrayList<>()));
        companies.add(new Company(2, new ArrayList<>()));
        companies.add(new Company(3, new ArrayList<>()));
        companies.add(new Company(4, new ArrayList<>()));
        companies.add(new Company(5, new ArrayList<>()));
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public Boolean addCompany(Company company) {
        return this.companies.add(company);
    }
}
