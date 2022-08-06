package com.demo.capstone.service;

import com.demo.capstone.dto.EmployeeDTO;
import com.demo.capstone.dto.Status;
import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Status status = new Status();
        int departmentId = employeeDTO.getDepartmentId();
        if(departmentId == 0) {
            status.setMessage("Department id is Mandatory");
        } else {
            Department department = departmentService.getDepartmentById((long) departmentId);
            if(department == null) {
                status.setMessage("Department id doesn't exists");
            } else {
                Employee employee = null;
                try {
                    employee = getEmployee(employeeDTO, department);
                } catch (Exception e) {
                    status.setMessage(e.getMessage());
                    employeeDTO.setStatus(status);
                    return employeeDTO;
                }
                employeeRepository.save(employee);
                status.setMessage("Employee saved Successfully");
            }
        }
        employeeDTO.setStatus(status);
        return employeeDTO;
    }

    public Employee getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).isPresent()
                ? employeeRepository.findById(employeeId).get() : null;
        return employee;
    }

    public Employee getEmployee(EmployeeDTO employeeDTO, Department department) throws Exception{
        Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(employeeDTO.getDateOfBirth());
        Date doj = new SimpleDateFormat("dd/MM/yyyy").parse(employeeDTO.getDateOfJoining());
        Employee employee = Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .gender(employeeDTO.getGender())
                .emailId(employeeDTO.getEmailId())
                .dateOfBirth(dob)
                .dateOfJoining(doj)
                .salary(employeeDTO.getSalary())
                .department(department)
                .build();
        return employee;
    }
}
