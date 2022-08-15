package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.EmployeeDTO;
import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.exceptions.DepartmentIdNotFoundException;
import com.demo.capstone.repository.DepartmentRepository;
import com.demo.capstone.repository.EmployeeRepository;
import com.demo.capstone.service.DepartmentService;
import com.demo.capstone.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;


import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {

    private String firstName = "Rahul";
    private String lastName = "Dravid";
    private String gender = "M";
    private String emailId = "rahul.dravid@gmil.com";
    private String dateOfBirth = "23/08/1995";
    private String dateOfJoining = "18/07/2022";
    private Long salary = 25000l;
    private Long departmentId = 1l;
    private String message = "Hello";

    @Mock
    public EmployeeRepository employeeRepository;

    @Mock
    public DepartmentRepository departmentRepository;

    public DepartmentService departmentService;

    public EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        departmentService = new DepartmentServiceImpl(departmentRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository, departmentService);
    }

    @Test
    public void addEmployeeShouldReturnExceptionIfDeptIdIsNull() {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .build();
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        Exception exception = assertThrows(DepartmentIdNotFoundException.class, () -> employeeServiceImpl.addEmployee(employeeDTO));
        assertEquals("DepartmentId null doesn't exists", exception.getMessage());
    }


    @Test
    public void addEmployeeShouldReturnExceptionIfDeptIdIsNotPresent() {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .departmentId(departmentId)
                .build();
        when(departmentRepository.findById(departmentId)).thenReturn(null);
        when(departmentService.getDepartmentById(departmentId)).thenReturn(null);

        Exception exception = assertThrows(DepartmentIdNotFoundException.class, () -> employeeService.addEmployee(employeeDTO));
        assertEquals("DepartmentId "+departmentId+" doesn't exists", exception.getMessage());
    }

    @Test
    public void testForAddEmployee() throws Exception {
        Long deptId = 10l;
        String deptName = "HR";


        Department department = Department.builder()
                .deptId(deptId)
                .deptName(deptName)
                .build();

        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .departmentId(deptId)
                .build();

        Optional opt = Optional.of(department);
        when(departmentRepository.findById(deptId)).thenReturn(opt);


        EmployeeDTO employeeDTO1 = employeeService.addEmployee(employeeDTO);
        assertEquals(firstName, employeeDTO1.getFirstName());
        assertEquals(lastName, employeeDTO1.getLastName());
        assertEquals(gender, employeeDTO1.getGender());
        assertEquals(emailId, employeeDTO1.getEmailId());
        assertEquals(dateOfBirth, employeeDTO1.getDateOfBirth());
        assertEquals(dateOfJoining, employeeDTO1.getDateOfJoining());
        assertEquals(salary, employeeDTO1.getSalary());
        assertEquals(deptId, employeeDTO1.getDepartmentId());
        assertEquals("Employee saved Successfully", employeeDTO1.getStatus().getMessage());
    }

    @Test
    public void testForFindByDeptId() {
        List<Employee> list = new ArrayList<>();
        String deptName = "HR";
        Date dob = new Date(1992, 11, 19);
        Date doj = new Date(2022, 07, 18);
        Department department = Department.builder()
                .deptId(departmentId)
                .deptName(deptName)
                .build();

        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dob)
                .dateOfJoining(doj)
                .salary(salary)
                .department(department)
                .build();

        Employee employee2 = Employee.builder()
                .firstName(firstName+"1")
                .lastName(lastName+"1")
                .gender(gender)
                .emailId(firstName+"."+lastName+"@gmail.com")
                .dateOfBirth(dob)
                .dateOfJoining(doj)
                .salary(salary)
                .department(department)
                .build();
        list.add(employee);
        list.add(employee2);

        when(employeeRepository.findByDeptId(departmentId)).thenReturn(list);
        List<Employee> employeeList = employeeService.findByDeptId(departmentId);

        assertEquals(list.size(), employeeList.size());
    }


    @Test
    public void testForGetEmployeeById() {
        Long employeeId = 1l;
        String deptName = "HR";
        Date dob = new Date(1992, 11, 19);
        Date doj = new Date(2022, 07, 18);

        Department department = Department.builder()
                .deptId(departmentId)
                .deptName(deptName)
                .build();

        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dob)
                .dateOfJoining(doj)
                .salary(salary)
                .department(department)
                .build();

        Optional opt = Optional.of(employee);
        when(employeeRepository.findById(employeeId)).thenReturn(opt);
        Employee employee1 = employeeService.getEmployeeById(employeeId);
        assertEquals(employee.getEmployeeId(), employee1.getEmployeeId());
        assertEquals(employee.getFirstName(), employee1.getFirstName());
        assertEquals(employee.getLastName(), employee1.getLastName());
    }

}
