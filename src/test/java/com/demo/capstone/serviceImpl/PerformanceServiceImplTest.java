package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.PerformanceDTO;
import com.demo.capstone.dto.Status;
import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.entity.Performance;
import com.demo.capstone.exceptions.DepartmentAlreadyExistsException;
import com.demo.capstone.exceptions.EmployeeNotFoundException;
import com.demo.capstone.exceptions.InvalidRatingException;
import com.demo.capstone.repository.DepartmentRepository;
import com.demo.capstone.repository.EmployeeRepository;
import com.demo.capstone.repository.PerformanceRepository;
import com.demo.capstone.service.DepartmentService;
import com.demo.capstone.service.EmployeeService;
import com.demo.capstone.service.PerformanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class PerformanceServiceImplTest {

    @Mock
    private PerformanceRepository performanceRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;


    private EmployeeService employeeService;

    public DepartmentService departmentService;

    public PerformanceService performanceService;


    @BeforeEach
    public void setUp(){
        departmentService = new DepartmentServiceImpl(departmentRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository, departmentService);
        performanceService = new PerformanceServiceImpl(performanceRepository, employeeService);
    }

    @Test
    public void testForAddEmployeePerformanceEmployeeIdCannotBeZero() {
        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .employeeId(0l)
                .rating(3)
                .build();
        Exception exception = assertThrows(EmployeeNotFoundException.class, () -> performanceService.addEmployeePerformance(performanceDTO));
        assertEquals("Employee Id cannot be zero", exception.getMessage());
    }

    @Test
    public void testForAddEmployeePerformanceEmployeeDoesntExists() {
        Long employeeId = 2l;
        int rating = 3;
        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .employeeId(employeeId)
                .rating(rating)
                .build();
        when(employeeRepository.findById(employeeId)).thenReturn(null);
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> performanceService.addEmployeePerformance(performanceDTO));
        assertEquals("Employee with 2 doesn't exists", exception.getMessage());
    }


    @Test
    public void testForAddEmployeePerformanceAdd() {
        Integer rating = 5;

        Long employeeId = 21l;
        String firstName = "Rahul";
        String lastName = "Dravid";
        String gender = "M";
        String emailId = "rahul.dravid@gmail.com";
        Date dateOfBirth = new Date(1992, 11, 19);
        Date dateOfJoining = new Date(2022, 07, 18);;
        Long salary = 25000l;
        String deptName = "HR";

        Department department = Department.builder()
                .deptName(deptName)
                .build();

        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .department(department)
                .build();
        Optional opt = Optional.of(employee);

        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .rating(rating)
                .employeeId(employeeId)
                .build();
        when(employeeRepository.findById(employeeId)).thenReturn(opt);
        when(performanceRepository.findByEmployeeId(employeeId)).thenReturn(null);
        PerformanceDTO performanceDTO1 = performanceService.addEmployeePerformance(performanceDTO);
        assertEquals("Rating of Employee is saved", performanceDTO1.getStatus().getMessage());

    }

    @Test
    public void testForAddEmployeePerformanceUpdate() {
        Integer rating = 5;
        Long employeeId = 21l;
        String firstName = "Rahul";
        String lastName = "Dravid";
        String gender = "M";
        String emailId = "rahul.dravid@gmail.com";
        Date dateOfBirth = new Date(1992, 11, 19);
        Date dateOfJoining = new Date(2022, 07, 18);;
        Long salary = 25000l;
        String deptName = "HR";
        Department department = Department.builder()
                .deptName(deptName)
                .build();
        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .department(department)
                .build();
        Optional opt = Optional.of(employee);
        Performance performance = Performance.builder()
                .rating(rating)
                .employee(employee)
                .build();
        PerformanceDTO performanceDTO = PerformanceDTO.builder()
                .rating(rating)
                .employeeId(employeeId)
                .build();
        when(employeeRepository.findById(employeeId)).thenReturn(opt);
        when(performanceRepository.findByEmployeeId(employeeId)).thenReturn(performance);
        PerformanceDTO performanceDTO1 = performanceService.addEmployeePerformance(performanceDTO);
        assertEquals("Rating of Employee is updated", performanceDTO1.getStatus().getMessage());
    }

    @Test
    public void testForCheckIfRatingIsValid() {
        boolean isValid = performanceService.checkIfRatingIsValid(1);
        boolean isValid1 = performanceService.checkIfRatingIsValid(6);
        boolean isValid2 = performanceService.checkIfRatingIsValid(0);
        assertEquals(true, isValid);
        assertEquals(false, isValid1);
        assertEquals(false, isValid2);
    }
}
