package com.demo.capstone.repositoryImpl;

import com.demo.capstone.repository.BusinessCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BusinessCustomRepositoryImpl implements BusinessCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Object[]> getAvgSalInEachDept() {
        Query query = entityManager.createQuery(""
                + "select employee.department.deptId, sum(employee.salary)/count(*) "
                + "from Employee employee "
                + "group by employee.department.deptId ");
        return query.getResultList();
    }

    @Override
    public List<Object[]> getAvgEmpSalInEachDeptByRating() {
        Query query = entityManager.createQuery(""
                + "select employee.department.deptId, performance.rating, sum(employee.salary)/count(*) "
                + "from Employee employee, Performance performance "
                + "where employee.employeeId = performance.employee.employeeId "
                + "group by employee.department.deptId, performance.rating");
        return query.getResultList();
    }

    @Override
    public List<Object[]> getDeptWithHighestNoOfEmployees() {
        Query query = entityManager.createQuery(""
                + "select employee.department.deptId, count(*) "
                + "from Employee employee "
                + "group by employee.department.deptId "
                + "order by count(*) "
                + "desc").setMaxResults(1);
        return query.getResultList();
    }
}
