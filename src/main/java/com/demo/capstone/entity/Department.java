package com.demo.capstone.entity;


import lombok.*;
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
    Long dept_id;

    @Column(name = "dept_name")
    String deptName;

    @OneToMany(mappedBy = "department")
    List<Employee> employees;
}
