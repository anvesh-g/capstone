package com.demo.capstone.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeDTOTest {

    private String firstName = "Rahul";
    private String lastName = "Dravid";
    private String gender = "M";
    private String emailId = "rahul.dravid@gmil.com";
    private String dateOfBirth = "23/08/1995";
    private String dateOfJoining = "18/07/2022";
    private Long salary = 25000l;
    private Long departmentId = 1l;
    private String message = "Hello";


    @Test
    public void testForEmployeeDTO() {
        Status status = Status.builder()
                .message(message)
                .build();
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .departmentId(departmentId)
                .status(status)
                .build();

        EmployeeDTO employeeDTO1 = new EmployeeDTO(firstName, lastName, gender, emailId, dateOfBirth, dateOfJoining, salary, departmentId, status);

        EmployeeDTO employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setFirstName(firstName);
        employeeDTO2.setLastName(lastName);
        employeeDTO2.setGender(gender);
        employeeDTO2.setEmailId(emailId);
        employeeDTO2.setDateOfBirth(dateOfBirth);
        employeeDTO2.setDateOfJoining(dateOfJoining);
        employeeDTO2.setSalary(salary);
        employeeDTO2.setDepartmentId(departmentId);
        employeeDTO2.setStatus(status);


        assertEquals(firstName, employeeDTO.getFirstName());
        assertEquals(lastName, employeeDTO.getLastName());
        assertEquals(gender, employeeDTO.getGender());
        assertEquals(emailId, employeeDTO.getEmailId());
        assertEquals(dateOfBirth, employeeDTO.getDateOfBirth());
        assertEquals(dateOfJoining, employeeDTO.getDateOfJoining());
        assertEquals(salary, employeeDTO.getSalary());
        assertEquals(departmentId, employeeDTO.getDepartmentId());
        assertEquals(message, employeeDTO.getStatus().getMessage());



        assertEquals(firstName, employeeDTO1.getFirstName());
        assertEquals(lastName, employeeDTO1.getLastName());
        assertEquals(gender, employeeDTO1.getGender());
        assertEquals(emailId, employeeDTO1.getEmailId());
        assertEquals(dateOfBirth, employeeDTO1.getDateOfBirth());
        assertEquals(dateOfJoining, employeeDTO1.getDateOfJoining());
        assertEquals(salary, employeeDTO1.getSalary());
        assertEquals(departmentId, employeeDTO1.getDepartmentId());
        assertEquals(message, employeeDTO1.getStatus().getMessage());


        assertEquals(firstName, employeeDTO2.getFirstName());
        assertEquals(lastName, employeeDTO2.getLastName());
        assertEquals(gender, employeeDTO2.getGender());
        assertEquals(emailId, employeeDTO2.getEmailId());
        assertEquals(dateOfBirth, employeeDTO2.getDateOfBirth());
        assertEquals(dateOfJoining, employeeDTO2.getDateOfJoining());
        assertEquals(salary, employeeDTO2.getSalary());
        assertEquals(departmentId, employeeDTO2.getDepartmentId());
        assertEquals(message, employeeDTO2.getStatus().getMessage());
    }
}
