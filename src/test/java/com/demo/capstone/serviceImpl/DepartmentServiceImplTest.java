package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.DepartmentDTO;
import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.exceptions.DepartmentAlreadyExistsException;
import com.demo.capstone.repository.DepartmentRepository;
import com.demo.capstone.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    public DepartmentRepository departmentRepository;

    DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        departmentService = new DepartmentServiceImpl(departmentRepository);
    }

    @Test
    public void testForAddDepartment() {
        String deptName = "HR";
        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .deptName(deptName)
                .build();
        when(departmentRepository.findByDeptName(deptName)).thenReturn(null);
        DepartmentDTO departmentDTO1 = departmentService.addDepartment(departmentDTO);
        assertEquals("Department saved successfully", departmentDTO1.getStatus().getMessage());

    }

    @Test
    public void testForAddDepartmentWhenDepartmentAlreadyExists() {
        Long deptId = 10l;
        String deptName = "HR";

        Long employeeId = 21l;
        String firstName = "Rahul";
        String lastName = "Dravid";
        String gender = "M";
        String emailId = "rahul.dravid@gmail.com";
        Date dateOfBirth = new Date(1992, 11, 19);
        Date dateOfJoining = new Date(2022, 07, 18);;
        Long salary = 25000l;

        List<Employee> employeeList = new ArrayList<>();

        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .build();

        employeeList.add(employee);

        Department department = Department.builder()
                .deptId(deptId)
                .deptName(deptName)
                .employees(employeeList)
                .build();

        employeeList.get(0).setDepartment(department);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);

        when(departmentRepository.findByDeptName(deptName)).thenReturn(departmentList);

        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .deptName(deptName)
                .build();

        Exception exception = assertThrows(DepartmentAlreadyExistsException.class,
                () -> departmentService.addDepartment(departmentDTO));
        assertEquals("Department already exists", exception.getMessage());

    }

    @Test
    public void testForGetDepartmentById() {

        Long deptId = 10l;
        String deptName = "HR";

        Long employeeId = 21l;
        String firstName = "Rahul";
        String lastName = "Dravid";
        String gender = "M";
        String emailId = "rahul.dravid@gmail.com";
        Date dateOfBirth = new Date(1992, 11, 19);
        Date dateOfJoining = new Date(2022, 07, 18);;
        Long salary = 25000l;

        List<Employee> employeeList = new ArrayList<>();

        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .emailId(emailId)
                .dateOfBirth(dateOfBirth)
                .dateOfJoining(dateOfJoining)
                .salary(salary)
                .build();
        employeeList.add(employee);
        Department department = Department.builder()
                .deptId(deptId)
                .deptName(deptName)
                .employees(employeeList)
                .build();
        Optional opt = Optional.of(department);
        when(departmentRepository.findById(deptId)).thenReturn(opt);
        Department department1 = departmentService.getDepartmentById(deptId);
        assertEquals(deptName, department1.getDeptName());
        assertEquals(1, department1.getEmployees().size());
    }

    @Test
    public void testForGetDepartmentByIdNotFound() {
        Long deptId = 2l;
        when(departmentRepository.findById(deptId)).thenReturn(null);
        Department department = departmentService.getDepartmentById(deptId);
        assertEquals(null, department);
    }
}
