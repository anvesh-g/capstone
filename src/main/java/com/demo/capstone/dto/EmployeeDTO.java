package com.demo.capstone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.*;
import java.io.Serializable;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO implements Serializable {

    @NotBlank(message = "Employee first name is required")
    @Pattern(regexp = "[^0-9]*", message = "first name cannot contain numbers")
    String firstName;

    @NotBlank(message = "Employee first name is required")
    @Pattern(regexp = "[^0-9]*", message = "last name cannot contain numbers")
    String lastName;

    @NotBlank(message = "Employee gender is required")
    String gender;

    @Email
    String emailId;

    @NotNull(message = "Date of birth cannot be null")
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",
            message = "dateOfBirth should be of format dd/mm/yyyy")
    String dateOfBirth;

    @NotNull(message = "Date of joining cannot be null")
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",
            message = "dateOfJoining should be of format dd/mm/yyyy")
    String dateOfJoining;

    @NotNull(message = "Specify salary")
    @Min(value = 0, message = "Salary cannot be less than 0")@Max(value = 10000000, message = "Salary cannot be greater than 10000000")
    Long salary;

    @NotNull(message = "Department Id cannot be null")
    @Min(value = 1, message = "Department Is cannot be less than 1")
    Long departmentId;

    Status status;

}
