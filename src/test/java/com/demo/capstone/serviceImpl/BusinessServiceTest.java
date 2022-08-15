package com.demo.capstone.serviceImpl;

import com.demo.capstone.dto.AvgSalInEachDept;
import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Employee;
import com.demo.capstone.repository.BusinessCustomRepository;
import com.demo.capstone.repository.DepartmentRepository;
import com.demo.capstone.repository.EmployeeRepository;
import com.demo.capstone.service.DepartmentService;
import com.demo.capstone.service.EmployeeService;
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
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BusinessServiceTest {

    @Mock
    private BusinessCustomRepository businessCustomRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    private DepartmentService departmentService;

    private EmployeeService employeeService;

    private BusinessService businessService;

    @BeforeEach
    public void setUp(){
        departmentService = new DepartmentServiceImpl(departmentRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository, departmentService);
        businessService = new BusinessService(businessCustomRepository, departmentService, employeeService);
    }

    @Test
    public void testForGetAvgSalInEachDept() {

        Object[] obj1 = {1l, 20000l};
        Object[] obj2 = {2l, 30000l};

        List<Object[]> objArrList = new ArrayList();
        objArrList.add(obj1);
        objArrList.add(obj2);

        Long deptId = 1l;
        String deptName = "HR";

        Long employeeId = 21l;
        String firstName = "Rahul";
        String lastName = "Dravid";
        String gender = "M";
        String emailId = "rahul.dravid@gmail.com";
        Date dateOfBirth = new Date(1992, 11, 19);
        Date dateOfJoining = new Date(2022, 07, 18);;
        Long salary = 20000l;
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
                .deptId(1l)
                .deptName(deptName)
                .employees(employeeList)
                .build();

        employeeList.get(0).setDepartment(department);

        Long deptId1 = 2l;
        String deptName1 = "HR1";

        Long employeeId1 = 22l;
        String firstName1 = "Rahul1";
        String lastName1 = "Dravid1";
        String gender1 = "M";
        String emailId1 = "rahul1.dravid@gmail.com";
        Date dateOfBirth1 = new Date(1993, 11, 19);
        Date dateOfJoining1 = new Date(2021, 07, 18);;
        Long salary1 = 30000l;

        List<Employee> employeeList1 = new ArrayList<>();

        Employee employee1 = Employee.builder()
                .employeeId(employeeId1)
                .firstName(firstName1)
                .lastName(lastName1)
                .gender(gender1)
                .emailId(emailId1)
                .dateOfBirth(dateOfBirth1)
                .dateOfJoining(dateOfJoining1)
                .salary(salary1)
                .build();

        employeeList1.add(employee);

        Department department1 = Department.builder()
                .deptId(2l)
                .deptName(deptName1)
                .employees(employeeList1)
                .build();

        employeeList1.get(0).setDepartment(department);

        Optional<Department> opt = Optional.of(department);
        Optional<Department> opt1 = Optional.of(department1);
        when(businessCustomRepository.getAvgSalInEachDept()).thenReturn(objArrList);
        when(departmentRepository.findById(1l)).thenReturn(opt);
        when(departmentRepository.findById(2l)).thenReturn(opt1);

        List<AvgSalInEachDept> avgSalInEachDeptList = businessService.getAvgSalInEachDept();

        assertEquals(2, avgSalInEachDeptList.size());
        assertEquals(deptId, avgSalInEachDeptList.get(0).getDeptId());
        assertEquals(deptId1, avgSalInEachDeptList.get(1).getDeptId());
        assertEquals(deptName, avgSalInEachDeptList.get(0).getDeptName());
        assertEquals(deptName1, avgSalInEachDeptList.get(1).getDeptName());
        assertEquals(Double.parseDouble(salary+""), avgSalInEachDeptList.get(0).getSalary());
        assertEquals(Double.parseDouble(salary1+""), avgSalInEachDeptList.get(1).getSalary());
    }

    @Test
    public void testForGetAvgEmpSalInEachDeptByRating() {

    }

    @Test
    public void testForGetDeptWithHighestNoOfEmployees() {

    }
}
