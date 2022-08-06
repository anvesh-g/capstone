package com.demo.capstone.dto;


import com.demo.capstone.entity.Department;
import com.demo.capstone.entity.Performance;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {
    String firstName;
    String lastName;
    String gender;
    String emailId;
    String dateOfBirth;
    String dateOfJoining;
    Long salary;
    int departmentId;
    Status status;

}
