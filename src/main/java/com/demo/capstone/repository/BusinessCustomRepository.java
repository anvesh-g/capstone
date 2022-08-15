package com.demo.capstone.repository;


import java.util.List;

public interface BusinessCustomRepository {

    List<Object[]> getAvgSalInEachDept();

    List<Object[]> getAvgEmpSalInEachDeptByRating();

    List<Object[]> getDeptWithHighestNoOfEmployees();
}
