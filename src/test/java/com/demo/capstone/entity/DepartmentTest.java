package com.demo.capstone.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentTest {

    private Long deptId = 10l;
    private String deptName = "HR";

    private Long employeeId = 21l;
    private String firstName = "Rahul";
    private String lastName = "Dravid";
    private String gender = "M";
    private String emailId = "rahul.dravid@gmail.com";
    private Date dateOfBirth = new Date(1992, 11, 19);
    private Date dateOfJoining = new Date(2022, 07, 18);;
    private Long salary = 25000l;


    @Test
    public void testForDepartment() {
        List<Employee> employeeList = new ArrayList<>();

        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .build();

        employeeList.add(employee);

        Department department = Department.builder()
                .deptId(deptId)
                .deptName(deptName)
                .employees(employeeList)
                .build();

        employeeList.get(0).setDepartment(department);

        assertEquals(deptId, department.getDeptId());
        assertEquals(deptName, department.getDeptName());
        assertEquals(firstName, employeeList.get(0).getFirstName());
        assertEquals(lastName, employeeList.get(0).getLastName());
        assertEquals(gender, employeeList.get(0).getGender());
        assertEquals(emailId, employeeList.get(0).getEmailId());
        assertEquals(dateOfBirth, employeeList.get(0).getDateOfBirth());
        assertEquals(dateOfJoining, employeeList.get(0).getDateOfJoining());
        assertEquals(salary, employeeList.get(0).getSalary());
        assertEquals(deptName, employeeList.get(0).getDepartment().getDeptName());
    }
}
