package com.demo.capstone.controller;

import com.demo.capstone.service.DepartmentService;
import com.demo.capstone.service.EmployeeService;
import com.demo.capstone.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PerformanceService performanceService;

    @GetMapping(value = "/avgSalaryInEachDept")
    public void averageSalaryInEachDepartment() {
        //TODO IMPLEMENTATION
        /*
         select dept_id, sum(salary)/count(*) from employee
         group by dept_id;
        */
        System.out.println("avgSalaryInEachDept");
    }

    @GetMapping(value = "/avgSalaryInEachDeptByRating")
    public void averageEmployeeSalaryInEachDepartmentForEachRating() {
        //TODO IMPLEMENTATION
        /*
            select e.dept_id, p.rating, sum(salary)/count(*) from employee e, performance p
            where e.employee_id = p.employee_id
            group by e.dept_id, p.rating;
         */
        System.out.println("avgSalaryInEachDeptByRating");
    }

    @GetMapping(value = "/deptWithHighestNumberOfEmployees")
    public void departmentWithHighestNumberOfEmployees() {
            //TODO IMPLEMENTATION
            /*
                select dept_id, count(*) from employee
                group by dept_id
                order by count(*) desc
                limit 1;
             */
        System.out.println("deptWithHighestNumberOfEmployees");
    }
}
