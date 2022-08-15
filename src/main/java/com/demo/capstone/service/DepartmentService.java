package com.demo.capstone.service;

import com.demo.capstone.dto.DepartmentDTO;
import com.demo.capstone.entity.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);
    Department getDepartmentById(Long id);
}
