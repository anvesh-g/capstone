package com.demo.capstone.service;

import com.demo.capstone.dto.PerformanceDTO;
import org.springframework.stereotype.Service;

@Service
public interface PerformanceService {
    PerformanceDTO addEmployeePerformance(PerformanceDTO performanceDTO);

    boolean checkIfRatingIsValid(int rating);
}
