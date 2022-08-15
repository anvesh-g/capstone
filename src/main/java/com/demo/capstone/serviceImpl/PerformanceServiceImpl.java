package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.PerformanceDTO;
import com.demo.capstone.dto.Status;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.entity.Performance;
import com.demo.capstone.exceptions.EmployeeNotFoundException;
import com.demo.capstone.exceptions.InvalidRatingException;
import com.demo.capstone.repository.PerformanceRepository;
import com.demo.capstone.service.EmployeeService;
import com.demo.capstone.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("performanceService")
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    public PerformanceServiceImpl() {

    }

    public PerformanceServiceImpl(PerformanceRepository performanceRepository, EmployeeService employeeService) {
        this.performanceRepository = performanceRepository;
        this.employeeService = employeeService;
    }

    public PerformanceDTO addEmployeePerformance(PerformanceDTO performanceDTO) {
        Status status = new Status();
        if(performanceDTO.getEmployeeId() == 0) {
            throw new EmployeeNotFoundException("Employee Id cannot be zero");
        } else {
            Employee employee = employeeService.getEmployeeById(performanceDTO.getEmployeeId());
            if(employee == null) {
                throw new EmployeeNotFoundException("Employee with "+performanceDTO.getEmployeeId()+" doesn't exists");
            } else {
                if(checkIfRatingIsValid(performanceDTO.getRating())) {
                    Performance performance = performanceRepository.findByEmployeeId(performanceDTO.getEmployeeId());
                    if(performance != null) {
                        performance.setRating(performanceDTO.getRating());
                        status.setMessage("Rating of Employee is updated");
                    } else {
                        performance = getPerformanceEntity(performanceDTO, employee);
                        status.setMessage("Rating of Employee is saved");
                    }
                    performanceRepository.save(performance);
                } else {
                    throw new InvalidRatingException("Invalid Rating "+performanceDTO.getRating()
                            +" Rating should be in between 1 and 5");
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

    @Override
    public boolean checkIfRatingIsValid(int rating) {
        return rating >= 1 && rating <= 5 ? true : false;
    }
}
