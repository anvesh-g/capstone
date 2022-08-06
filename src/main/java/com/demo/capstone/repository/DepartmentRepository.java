package com.demo.capstone.repository;

import com.demo.capstone.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByDeptName(String deptName);
}

