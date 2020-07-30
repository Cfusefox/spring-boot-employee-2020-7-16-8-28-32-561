package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.mock;

public class CompanyServiceTest {

    @Test
    void should_return_company_list_when_find_company_information_given_null() {
        //given
        CompanyRepository mockedCompanyRepository = mock(CompanyRepository.class);
        CompanyService CompanyService = new CompanyService(mockedCompanyRepository);

        given(mockedCompanyRepository.findAll()).willReturn(Collections.singletonList(new Company(1, "alibaba", 50, null)));
        //when
        List<Company> companyList = CompanyService.findAll();
        //then

        assertNotNull(companyList);
    }

    @Test
    void should_return_certain_company_when_find_company_by_id_given_company_id() {
        //given
        CompanyRepository mockedCompanyRepository = mock(CompanyRepository.class);
        CompanyService CompanyService = new CompanyService(mockedCompanyRepository);

        given(mockedCompanyRepository.findById(1)).willReturn(java.util.Optional.of(new Company(1, "alibaba", 50, null)));
        //when
        Company company = CompanyService.findCompanyByID(1);
        //then

        assertNotNull(company);
    }

    @Test
    void should_return_company_employee_list_when_find_company_employee_list_by_id_given_company_id() {
        //given
        CompanyRepository mockedCompanyRepository = mock(CompanyRepository.class);
        CompanyService CompanyService = new CompanyService(mockedCompanyRepository);

        given(mockedCompanyRepository.findById(2)).willReturn(java.util.Optional.of(new Company(2, "OOCL", 0, new ArrayList<>())));
        //when
        List<Employee> employees = CompanyService.findCompanyEmployeesByID(2);
        //then

        assertNotNull(employees);
    }

    @Test
    void should_return_range_of_company_when_find_range_of_company_given_page_and_page_size() {
        //given
        CompanyRepository mockedCompanyRepository = mock(CompanyRepository.class);
        CompanyService employeeService = new CompanyService(mockedCompanyRepository);
        given(mockedCompanyRepository.findAll()).willReturn(new ArrayList<>());

        //when
        Page<Company> companies = employeeService.findRangeOfCompany(3, 3);

        //then
        assertEquals(null, companies);
    }

    @Test
    void should_return_company_when_add_company_given_company() {
        //given
        CompanyRepository mockedCompanyRepository = mock(CompanyRepository.class);
        CompanyService CompanyService = new CompanyService(mockedCompanyRepository);
        given(mockedCompanyRepository.save(new Company(1, "alibaba", 50, null))).willReturn(new Company(1, "alibaba", 50, null));
        //when
        Company company = CompanyService.addCompany(new Company(1, "alibaba", 50, null));
        //then

        assertNotNull(company);
    }

    @Test
    void should_return_company_when_delete_company_given_company_id() {
        //given
        CompanyRepository mockedCompanyRepository = mock(CompanyRepository.class);
        CompanyService CompanyService = new CompanyService(mockedCompanyRepository);

        given(mockedCompanyRepository.findById(1)).willReturn(java.util.Optional.of(new Company(1, "alibaba", 50, null)));
        //when
        Company company = CompanyService.deleteCompany(1);
        //then

        assertEquals(1, company.getCompanyID());
    }

    @Test
    void should_return_update_company_when_update_company_given_company() {
        //given
        CompanyRepository mockedCompanyRepository = mock(CompanyRepository.class);
        CompanyService companyService = new CompanyService(mockedCompanyRepository);
        given(mockedCompanyRepository.findById(1)).willReturn(java.util.Optional.of(new Company(1, "OOCL", 0, new ArrayList<>())));

        //when
        Company updateCompany = companyService.update(1, new Company(1, "OOIL", 0, new ArrayList<>()));


        //then
        assertEquals("OOIL", updateCompany.getCompanyName());

    }
}
