package com.demo.capstone.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Data
@Table(name="department")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {

    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long deptId;

    @Column(name = "dept_name")
    String deptName;

    @OneToMany(mappedBy = "departmentTest")
    List<Employee> employees;
}
