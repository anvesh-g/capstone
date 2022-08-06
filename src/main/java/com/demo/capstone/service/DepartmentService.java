package com.demo.capstone.service;

import com.demo.capstone.dto.DepartmentDTO;
import com.demo.capstone.dto.Status;
import com.demo.capstone.entity.Department;
import com.demo.capstone.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        Department department = getDepartmentEntity(departmentDTO);
        List<Department> departmentList= departmentRepository.findByDeptName(departmentDTO.getDeptName());
        if(departmentList == null || departmentList.size() == 0) {
            departmentRepository.save(department);
            Status status = Status.builder()
                    .message("Department saved successfully")
                    .build();
            departmentDTO.setStatus(status);
        } else {
            Status status = Status.builder()
                    .message("Department already exists")
                    .build();
            departmentDTO.setStatus(status);
        }
        return departmentDTO;
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).isPresent() ? departmentRepository.findById(id).get() : null;
    }

    public Department getDepartmentEntity(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .deptName(departmentDTO.getDeptName())
                .build();
        return department;
    }
}
