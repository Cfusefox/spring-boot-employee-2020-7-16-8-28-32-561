package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class EmployeeServiceTest {

    @Test
    void should_update_employee_when_update_employee_by_id_given_employee_information() {
        //given
        EmployeeRepository mockedEmployeeRespository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRespository);
        given(mockedEmployeeRespository.findById(5)).willReturn(java.util.Optional.of(new Employee(3, "ffff", 18, "male", 1000)));

        //when
        Employee updateEmployee = employeeService.update(5, new Employee(2, "test", 18, "male", 1000));


        //then
        //todo
        assertEquals("test",updateEmployee.getName());
        assertEquals(18,updateEmployee.getAge());
        assertEquals("male",updateEmployee.getGender());

    }

    @Test
    void should_all_employee_information_when_find_all_employee_information_given_null() {
        //given

        //when
        //todo rename
        EmployeeRepository mockedEmployeeRespository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRespository);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(3, "ffff", 18, "male", 1000));
        employeeList.add(new Employee(5, "ffff", 18, "male", 1000));
        employeeList.add(new Employee(4, "ffff", 18, "male", 1000));
        given(mockedEmployeeRespository.findAll()).willReturn(employeeList);

        //then

        assertNotNull(employeeService.findAll());
    }

    @Test
    void should_certain_employee_when_find_employee_by_id_given_id() {
        //given
        EmployeeRepository mockedEmployeeRespository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRespository);
        Employee employee = new Employee(3, "ffff", 18, "male", 1000);
        given(mockedEmployeeRespository.findById(3)).willReturn(java.util.Optional.of(employee));

        //when
        Employee certainEmployee = employeeService.findEmployeeByID(3);

        //then
        assertEquals(employee, certainEmployee);
    }

    @Test
    void should_certain_gender_employee_when_find_employee_by_gender_given_gender() {
        //given
        EmployeeRepository mockedEmployeeRespository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRespository);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(3, "ffff", 18, "male", 1000));
        employeeList.add(new Employee(5, "ffff", 18, "male", 1000));
        given(mockedEmployeeRespository.findAllByGender("male")).willReturn(employeeList);
        //when
        List<Employee> employees = employeeService.findEmployeeByGender("male");
        //then
        assertNotNull(employees);

    }

    @Test
    void should_range_of_employee_when_get_range_of_employees_given_page_and_page_size() {
        //given
        EmployeeRepository mockedEmployeeRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRepository);
        given(mockedEmployeeRepository.findAll(PageRequest.of(3, 3))).willReturn(Page.empty());

        //when
        Page<Employee> employees = employeeService.getRangeOfEmployees(3, 3);

        //then
        assertNotNull(employees);
    }

    @Test
    void should_return_employee_when_add_employee_given_employee() {
        //given
        EmployeeRepository mockedEmployeeRespository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRespository);
        Employee employee =new Employee(3, "ffff", 18, "male", 1000);

        given(mockedEmployeeRespository.save(employee)).willReturn(employee);

        //when
        Employee addedEmployee = employeeService.addEmployee(employee);

        //then
        assertEquals(employee, addedEmployee);
    }

    @Test
    void should_return_employee_when_delete_employee_given_employee() {
        //given
        EmployeeRepository mockedEmployeeRespository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeRespository);
        Employee employee =new Employee(3, "ffff", 18, "male", 1000);
        given(mockedEmployeeRespository.findById(employee.getEmployeeID())).willReturn(java.util.Optional.of(employee));

        //when
        Employee deletedEmployee = employeeService.deleteEmployee(employee);

        //then
        assertEquals(employee, deletedEmployee);
    }
}
