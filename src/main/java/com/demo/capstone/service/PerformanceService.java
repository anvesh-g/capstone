package com.demo.capstone.service;

import com.demo.capstone.dto.PerformanceDTO;
import com.demo.capstone.dto.Status;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.entity.Performance;
import com.demo.capstone.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private EmployeeService employeeService;



    public PerformanceDTO addEmployeePerformance(PerformanceDTO performanceDTO) {
        Status status = new Status();
        if(performanceDTO.getEmployeeId() == 0) {
            status.setMessage("Employee Id cannot be empty/zero");
        } else {
            Employee employee = employeeService.getEmployeeById(performanceDTO.getEmployeeId());
            if(employee == null) {
                status.setMessage("Employee Id doesn't exists");
            } else {
                if(checkIfRatingIsValid(performanceDTO.getRating())) {
                    Performance performance = getPerformanceEntity(performanceDTO, employee);
                    //TODO UPDATE RATING IF SAME EMPLOYEE IS PASSED INSTEAD OF SAVING AS NEW RECORD
                    performanceRepository.save(performance);
                    status.setMessage("Rating of Employee is saved");
                } else {
                    status.setMessage("Rating should be from 1 to 5");
                }
            }
        }
        performanceDTO.setStatus(status);
        return performanceDTO;
    }

    public Performance getPerformanceEntity(PerformanceDTO performanceDTO, Employee employee) {
        Performance performance = Performance.builder()
                .employee(employee)
                .rating(performanceDTO.getRating())
                .build();
        return performance;
    }

    public boolean checkIfRatingIsValid(int rating) {
        return rating >= 1 && rating <= 5 ? true : false;
    }
}
