package com.demo.capstone.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformanceDTOTest {

    private long employeeId = 123l;
    private int rating = 5;
    private String message = "Hello";

    @Test
    public void testForPerformanceDTOTest() {
        Status status = Status.builder()
                .message(message)
                .build();
        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .employeeId(employeeId)
                .rating(rating)
                .status(status)
                .build();

        PerformanceDTO performanceDTO1 = new PerformanceDTO(employeeId, rating, status);

        PerformanceDTO performanceDTO2 = new PerformanceDTO();
        performanceDTO2.setEmployeeId(employeeId);
        performanceDTO2.setRating(rating);
        performanceDTO2.setStatus(status);

        assertEquals(employeeId, performanceDTO.getEmployeeId());
        assertEquals(rating, performanceDTO.getRating());
        assertEquals(message, performanceDTO.getStatus().getMessage());

        assertEquals(employeeId, performanceDTO1.getEmployeeId());
        assertEquals(rating, performanceDTO1.getRating());
        assertEquals(message, performanceDTO1.getStatus().getMessage());

        assertEquals(employeeId, performanceDTO2.getEmployeeId());
        assertEquals(rating, performanceDTO2.getRating());
        assertEquals(message, performanceDTO2.getStatus().getMessage());

    }
}
