package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.AvgEmpSalInEachDeptByRating;
import com.demo.capstone.dto.AvgSalInEachDept;
import com.demo.capstone.dto.DeptWithHighestNoOfEmps;
import com.demo.capstone.dto.EmployeeDTO;
import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.repository.BusinessCustomRepository;
import com.demo.capstone.service.DepartmentService;
import com.demo.capstone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessService {

    @Autowired
    private BusinessCustomRepository businessCustomRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    public BusinessService(BusinessCustomRepository businessCustomRepository, DepartmentService departmentService,
                                EmployeeService employeeService) {
        this.businessCustomRepository = businessCustomRepository;
        this.departmentService = departmentService;
        this.employeeService =employeeService;
    }

    public List<AvgSalInEachDept> getAvgSalInEachDept() {
        List<Object[]> list = businessCustomRepository.getAvgSalInEachDept();
        return buildAvgSalInEachDeptList(list);
    }

    public List<AvgEmpSalInEachDeptByRating> getAvgEmpSalInEachDeptByRating() {
        List<Object[]> list = businessCustomRepository.getAvgEmpSalInEachDeptByRating();
        return buildAvgEmpSalInEachDeptByRating(list);
    }

    public List<DeptWithHighestNoOfEmps> getDeptWithHighestNoOfEmployees() {
        List<Object[]> list = businessCustomRepository.getDeptWithHighestNoOfEmployees();
        return buildDeptWithHighestNoOfEmp(list);
    }


    private List<AvgSalInEachDept> buildAvgSalInEachDeptList(List<Object[]> list) {
        List<AvgSalInEachDept> avgSalInEachDeptList = new ArrayList<>();
        for (Object[] obj : list )   {
            Department department = departmentService.getDepartmentById((Long) obj[0]);
            AvgSalInEachDept avgSalInEachDept = AvgSalInEachDept.builder()
                    .deptId(department.getDeptId())
                    .deptName(department.getDeptName())
                    .salary((Long) obj[1])
                    .build();
            avgSalInEachDeptList.add(avgSalInEachDept);
        }
        return avgSalInEachDeptList;
    }

    private List<AvgEmpSalInEachDeptByRating> buildAvgEmpSalInEachDeptByRating(List<Object[]> list) {
        List<AvgEmpSalInEachDeptByRating> avgEmpSalInEachDeptByRatingList = new ArrayList<>();
        for (Object[] obj : list )   {
            Department department = departmentService.getDepartmentById((Long) obj[0]);
            AvgEmpSalInEachDeptByRating avgEmpSalInEachDeptByRating = AvgEmpSalInEachDeptByRating.builder()
                    .deptId(department.getDeptId())
                    .deptName(department.getDeptName())
                    .rating((int) obj[1])
                    .build();
            avgEmpSalInEachDeptByRatingList.add(avgEmpSalInEachDeptByRating);
        }
        return avgEmpSalInEachDeptByRatingList;
    }

    private List<DeptWithHighestNoOfEmps> buildDeptWithHighestNoOfEmp(List<Object[]> list) {
        List<DeptWithHighestNoOfEmps> deptWithHighestNoOfEmpList = new ArrayList<>();
        for (Object[] obj : list )   {
            Department department = departmentService.getDepartmentById((Long)obj[0]);
            List<Employee> employees = department.getEmployees();
            List<EmployeeDTO> employeeDTOList = getEmployeeDTOList(employees);
            DeptWithHighestNoOfEmps deptWithHighestNoOfEmp = DeptWithHighestNoOfEmps.builder()
                    .deptId(department.getDeptId())
                    .deptName(department.getDeptName())
                    .noOfEmployees((long)obj[1])
                    .employeeDTOList(employeeDTOList)
                    .build();
            deptWithHighestNoOfEmpList.add(deptWithHighestNoOfEmp);
        }
        return deptWithHighestNoOfEmpList;
    }

    private List<EmployeeDTO> getEmployeeDTOList(List<Employee> employees) {
         return employees.stream().map(employee ->  EmployeeDTO.builder()
                     .firstName(employee.getFirstName())
                     .lastName(employee.getLastName())
                     .gender(employee.getGender())
                     .emailId(employee.getEmailId())
                     .dateOfBirth(String.valueOf(employee.getDateOfBirth()))
                     .dateOfJoining(String.valueOf(employee.getDateOfJoining()))
                     .salary(employee.getSalary())
                     .departmentId(employee.getDepartment().getDeptId())
                     .build()
                ).collect(Collectors.toList());
    }
}
