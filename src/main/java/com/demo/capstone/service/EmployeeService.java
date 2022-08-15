package com.demo.capstone.service;

import com.demo.capstone.dto.EmployeeDTO;
import com.demo.capstone.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

    Employee getEmployeeById(Long employeeId);

    List<Employee> findByDeptId(Long deptId);
}
