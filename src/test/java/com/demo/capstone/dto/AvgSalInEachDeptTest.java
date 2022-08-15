package com.demo.capstone.dto;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AvgSalInEachDeptTest implements Serializable {
    long deptId = 10;
    String deptName = "HR";
    double salary = 20000;

    @Test
    public void testForAvgSalInEachDept() {
        AvgSalInEachDept avgSalInEachDept = AvgSalInEachDept.builder()
                .deptId(deptId)
                .deptName(deptName)
                .salary(salary)
                .build();

        AvgSalInEachDept avgSalInEachDept1 = new AvgSalInEachDept(deptId, deptName, salary);

        AvgSalInEachDept avgSalInEachDept2 = new AvgSalInEachDept();
        avgSalInEachDept2.setDeptId(deptId);
        avgSalInEachDept2.setDeptName(deptName);
        avgSalInEachDept2.setSalary(salary);


        assertEquals(deptId, avgSalInEachDept.getDeptId());
        assertEquals(deptName, avgSalInEachDept.getDeptName());
        assertEquals(salary, avgSalInEachDept.getSalary());

        assertEquals(deptId, avgSalInEachDept1.getDeptId());
        assertEquals(deptName, avgSalInEachDept1.getDeptName());
        assertEquals(salary, avgSalInEachDept1.getSalary());


        assertEquals(deptId, avgSalInEachDept2.getDeptId());
        assertEquals(deptName, avgSalInEachDept2.getDeptName());
        assertEquals(salary, avgSalInEachDept2.getSalary());
    }
}
