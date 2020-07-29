package com.thoughtworks.springbootemployee.data;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyData {
    List<Company> companies = new ArrayList<>();

    public CompanyData() {
        companies.add(new Company(1, null));
        companies.add(new Company(2, null));
        companies.add(new Company(3, null));
        companies.add(new Company(4, null));
        companies.add(new Company(5, null));
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public Boolean addCompany(Company company) {
        return this.companies.add(company);
    }
}
