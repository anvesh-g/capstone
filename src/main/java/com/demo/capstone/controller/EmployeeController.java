package com.demo.capstone.controller;

import com.demo.capstone.dto.EmployeeDTO;
import com.demo.capstone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping(path = "/addEmployee", consumes = "application/json")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    //TODO IMPLEMENT END POINT TO LOAD ALL EMPLOYEES

    //TODO IMPLEMENT END POINT TO DELETE EMPLOYEE
}
