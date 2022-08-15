package com.demo.capstone.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeptWithHighestNoOfEmps implements Serializable {
    long deptId;
    String deptName;
    long noOfEmployees;
    List<EmployeeDTO> employeeDTOList;
}
