package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.DepartmentDTO;
import com.demo.capstone.dto.Status;
import com.demo.capstone.entity.Department;
import com.demo.capstone.exceptions.DepartmentAlreadyExistsException;
import com.demo.capstone.repository.DepartmentRepository;
import com.demo.capstone.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
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
            throw new DepartmentAlreadyExistsException("Department already exists");
        }
        return departmentDTO;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id) != null ? departmentRepository.findById(id).get() : null;
    }

    public Department getDepartmentEntity(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .deptName(departmentDTO.getDeptName())
                .build();
        return department;
    }
}
