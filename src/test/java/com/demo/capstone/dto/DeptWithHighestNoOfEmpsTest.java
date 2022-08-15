package com.demo.capstone.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeptWithHighestNoOfEmpsTest  {
    long deptId = 10;
    String deptName = "HR";
    long noOfEmployees = 5;
    List<EmployeeDTO> employeeDTOList;

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
    public void testForDeptWithHighestNoOfEmps() {
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
        List<EmployeeDTO> employeeDTOList = new ArrayList();
        employeeDTOList.add(employeeDTO);
        DeptWithHighestNoOfEmps deptWithHighestNoOfEmps = DeptWithHighestNoOfEmps.builder()
                .deptId(deptId)
                .deptName(deptName)
                .noOfEmployees(noOfEmployees)
                .employeeDTOList(employeeDTOList)
                .build();

        DeptWithHighestNoOfEmps deptWithHighestNoOfEmps1 = new DeptWithHighestNoOfEmps(deptId, deptName, noOfEmployees, employeeDTOList);

        DeptWithHighestNoOfEmps deptWithHighestNoOfEmps2 = new DeptWithHighestNoOfEmps();
        deptWithHighestNoOfEmps2.setDeptId(deptId);
        deptWithHighestNoOfEmps2.setDeptName(deptName);
        deptWithHighestNoOfEmps2.setNoOfEmployees(noOfEmployees);
        deptWithHighestNoOfEmps2.setEmployeeDTOList(employeeDTOList);


        assertEquals(deptId, deptWithHighestNoOfEmps.getDeptId());
        assertEquals(deptName, deptWithHighestNoOfEmps.getDeptName());
        assertEquals(noOfEmployees, deptWithHighestNoOfEmps.getNoOfEmployees());
        assertEquals(firstName, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getFirstName());
        assertEquals(lastName, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getLastName());
        assertEquals(gender, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getGender());
        assertEquals(emailId, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getEmailId());
        assertEquals(dateOfBirth, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getDateOfBirth());
        assertEquals(dateOfJoining, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getDateOfJoining());
        assertEquals(salary, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getSalary());
        assertEquals(departmentId, deptWithHighestNoOfEmps.getEmployeeDTOList().get(0).getDepartmentId());


        assertEquals(deptId, deptWithHighestNoOfEmps1.getDeptId());
        assertEquals(deptName, deptWithHighestNoOfEmps1.getDeptName());
        assertEquals(noOfEmployees, deptWithHighestNoOfEmps1.getNoOfEmployees());
        assertEquals(firstName, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getFirstName());
        assertEquals(lastName, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getLastName());
        assertEquals(gender, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getGender());
        assertEquals(emailId, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getEmailId());
        assertEquals(dateOfBirth, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getDateOfBirth());
        assertEquals(dateOfJoining, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getDateOfJoining());
        assertEquals(salary, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getSalary());
        assertEquals(departmentId, deptWithHighestNoOfEmps1.getEmployeeDTOList().get(0).getDepartmentId());


        assertEquals(deptId, deptWithHighestNoOfEmps2.getDeptId());
        assertEquals(deptName, deptWithHighestNoOfEmps2.getDeptName());
        assertEquals(noOfEmployees, deptWithHighestNoOfEmps2.getNoOfEmployees());
        assertEquals(firstName, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getFirstName());
        assertEquals(lastName, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getLastName());
        assertEquals(gender, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getGender());
        assertEquals(emailId, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getEmailId());
        assertEquals(dateOfBirth, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getDateOfBirth());
        assertEquals(dateOfJoining, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getDateOfJoining());
        assertEquals(salary, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getSalary());
        assertEquals(departmentId, deptWithHighestNoOfEmps2.getEmployeeDTOList().get(0).getDepartmentId());


    }
}
