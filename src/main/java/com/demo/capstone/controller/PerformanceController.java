package com.demo.capstone.controller;

import com.demo.capstone.dto.PerformanceDTO;
import com.demo.capstone.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping(value = "/reviewPerformance", consumes = "application/json")
    public ResponseEntity<PerformanceDTO> addEmployeeRating(@RequestBody PerformanceDTO performance) {
        PerformanceDTO performanceDTO = performanceService.addEmployeePerformance(performance);
        return new ResponseEntity<>(performanceDTO, HttpStatus.OK);
    }

    //TODO DELETE RATING OF EMPLOYEE

    //TODO GET RATING OF ALL EMPLOYEES
}
