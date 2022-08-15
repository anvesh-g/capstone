package com.demo.capstone.controller;

import com.demo.capstone.dto.DepartmentDTO;
import com.demo.capstone.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;

    @PostMapping(path ="/addDepartment", consumes = "application/json")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO department) {
        DepartmentDTO departmentDTO = departmentService.addDepartment(department);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    //TODO IMPLEMENT END POINT FOR GET ALL DEPARTMENTS

    //TODO IMPLEMENT END POINT FOR DELETE
}
