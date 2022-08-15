package com.demo.capstone.repository;

import com.demo.capstone.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PerformanceRepository extends JpaRepository<Performance, Integer> {

    @Query("select performance from Performance performance where performance.employee.employeeId = ?1")
    Performance findByEmployeeId(long employeeId);

}
