package com.demo.capstone.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentDTOTest {

    private String deptName = "HR";
    private String message = "Hello";

    @Test
    public void testForDepartmentDTO() {
        Status status = Status.builder()
                .message(message)
                .build();

        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .deptName(deptName)
                .status(status)
                .build();

        DepartmentDTO departmentDTO1 = new DepartmentDTO(deptName, status);

        DepartmentDTO departmentDTO2 = new DepartmentDTO();
        departmentDTO2.setDeptName(deptName);
        departmentDTO2.setStatus(status);

        assertEquals(deptName, departmentDTO.getDeptName());
        assertEquals(message, departmentDTO.getStatus().getMessage());

        assertEquals(deptName, departmentDTO1.getDeptName());
        assertEquals(message, departmentDTO1.getStatus().getMessage());

        assertEquals(deptName, departmentDTO2.getDeptName());
        assertEquals(message, departmentDTO2.getStatus().getMessage());


    }
}
