package com.demo.capstone.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformanceTest {

    Integer rating = 5;

    private Long employeeId = 21l;
    private String firstName = "Rahul";
    private String lastName = "Dravid";
    private String gender = "M";
    private String emailId = "rahul.dravid@gmail.com";
    private Date dateOfBirth = new Date(1992, 11, 19);
    private Date dateOfJoining = new Date(2022, 07, 18);;
    private Long salary = 25000l;
    private String deptName = "HR";

    @Test
    public void testForPerformance() {

        Department department = Department.builder()
                .deptName(deptName)
                .build();

        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .department(department)
                .build();


        Performance performance = Performance.builder()
                .rating(rating)
                .employee(employee)
                .build();

        assertEquals(rating, performance.getRating());
        assertEquals(employeeId, performance.getEmployee().getEmployeeId());
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(gender, employee.getGender());
        assertEquals(emailId, employee.getEmailId());
        assertEquals(dateOfBirth, employee.getDateOfBirth());
        assertEquals(dateOfJoining, employee.getDateOfJoining());
        assertEquals(salary, employee.getSalary());
        assertEquals(deptName, employee.getDepartment().getDeptName());



    }
}
