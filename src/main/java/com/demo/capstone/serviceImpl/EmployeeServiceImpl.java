package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.EmployeeDTO;
import com.demo.capstone.dto.Status;
import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.repository.EmployeeRepository;
import com.demo.capstone.exceptions.DepartmentIdNotFoundException;
import com.demo.capstone.service.DepartmentService;
import com.demo.capstone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Qualifier("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    public EmployeeServiceImpl() {
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Status status = new Status();
        Long departmentId = employeeDTO.getDepartmentId();
        if(departmentId == null || departmentId == 0) {
            status.setMessage("Department id is Mandatory");
            throw new DepartmentIdNotFoundException("DepartmentId " +departmentId+ " doesn't exists");
        } else {
            Department department = departmentService.getDepartmentById(departmentId);
            if(department == null) {
                throw new DepartmentIdNotFoundException("DepartmentId " +departmentId+ " doesn't exists");
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

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId) != null
                ? employeeRepository.findById(employeeId).get() : null;
        return employee;
    }

    @Override
    public List<Employee> findByDeptId(Long deptId) {
        return employeeRepository.findByDeptId(deptId);
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
