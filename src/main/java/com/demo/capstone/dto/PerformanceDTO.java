package com.demo.capstone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerformanceDTO implements Serializable {

    @NotBlank(message = "Employee first name is required")
    @Min(value = 1, message = "Employee Id cannot be less than 1")
    Long employeeId;

    @NotBlank(message = "Employee first name is required")
    @Min(value = 1, message = "Rating cannot be less than 1")
    int rating;

    Status status;
}
