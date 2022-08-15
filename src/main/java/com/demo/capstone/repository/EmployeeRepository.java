package com.demo.capstone.repository;

import com.demo.capstone.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select employee from Employee employee where employee.department.deptId = ?1")
    List<Employee> findByDeptId(Long deptId);
}
