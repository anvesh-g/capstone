package com.demo.capstone.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvgEmpSalInEachDeptByRatingTest {
    private long deptId = 10;
    private String deptName = "HR";
    private int rating = 5;

    @Test
    public void testForAvgEmpSalInEachDeptByRating() {
        AvgEmpSalInEachDeptByRating avgEmpSalInEachDeptByRating = AvgEmpSalInEachDeptByRating.builder()
                .rating(rating)
                .deptId(deptId)
                .deptName(deptName)
                .build();

        AvgEmpSalInEachDeptByRating avgEmpSalInEachDeptByRating1 = new AvgEmpSalInEachDeptByRating(deptId, deptName, rating);

        AvgEmpSalInEachDeptByRating avgEmpSalInEachDeptByRating2 = new AvgEmpSalInEachDeptByRating();
        avgEmpSalInEachDeptByRating2.setDeptId(deptId);
        avgEmpSalInEachDeptByRating2.setDeptName(deptName);
        avgEmpSalInEachDeptByRating2.setRating(rating);

        assertEquals(rating, avgEmpSalInEachDeptByRating.getRating());
        assertEquals(deptId, avgEmpSalInEachDeptByRating.getDeptId());
        assertEquals(deptName, avgEmpSalInEachDeptByRating.getDeptName());


        assertEquals(rating, avgEmpSalInEachDeptByRating1.getRating());
        assertEquals(deptId, avgEmpSalInEachDeptByRating1.getDeptId());
        assertEquals(deptName, avgEmpSalInEachDeptByRating1.getDeptName());

        assertEquals(rating, avgEmpSalInEachDeptByRating2.getRating());
        assertEquals(deptId, avgEmpSalInEachDeptByRating2.getDeptId());
        assertEquals(deptName, avgEmpSalInEachDeptByRating2.getDeptName());

    }
}
