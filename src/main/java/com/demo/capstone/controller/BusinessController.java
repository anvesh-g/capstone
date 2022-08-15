package com.demo.capstone.controller;

import com.demo.capstone.dto.AvgEmpSalInEachDeptByRating;
import com.demo.capstone.dto.AvgSalInEachDept;
import com.demo.capstone.dto.DeptWithHighestNoOfEmps;
import com.demo.capstone.serviceImpl.BusinessService;
import com.demo.capstone.service.DepartmentService;
import com.demo.capstone.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessController {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @Autowired
    @Qualifier("performanceService")
    private PerformanceService performanceService;

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/avgSalaryInEachDept")
    public ResponseEntity<List<AvgSalInEachDept>> averageSalaryInEachDepartment() {
        List<AvgSalInEachDept> avgSalInEachDeptList = businessService.getAvgSalInEachDept();
        return new ResponseEntity<>(avgSalInEachDeptList, HttpStatus.OK);
    }

    @GetMapping(value = "/avgSalaryInEachDeptByRating")
    public ResponseEntity<List<AvgEmpSalInEachDeptByRating>> averageEmployeeSalaryInEachDepartmentForEachRating() {
       List<AvgEmpSalInEachDeptByRating> avgEmpSalInEachDeptByRatingList
               = businessService.getAvgEmpSalInEachDeptByRating();
       return new ResponseEntity<>(avgEmpSalInEachDeptByRatingList, HttpStatus.OK);
    }

    @GetMapping(value = "/deptWithHighestNumberOfEmployees")
    public ResponseEntity<List<DeptWithHighestNoOfEmps>> departmentWithHighestNumberOfEmployees() {
        List<DeptWithHighestNoOfEmps> deptWithHighestNoOfEmpList
                = businessService.getDeptWithHighestNoOfEmployees();
        return new ResponseEntity<>(deptWithHighestNoOfEmpList, HttpStatus.OK);
    }
}
