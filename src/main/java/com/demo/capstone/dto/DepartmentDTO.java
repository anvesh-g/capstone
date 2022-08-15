package com.demo.capstone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentDTO implements Serializable {

    @NotBlank(message = "Employee first name is required")
    @Pattern(regexp = "[^0-9]*", message = "dept name cannot contain numbers")
    String deptName;
    Status status;
}
