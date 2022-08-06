package com.demo.capstone.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PerformanceDTO {
    Long employeeId;
    Integer rating;
    Status status;
}
