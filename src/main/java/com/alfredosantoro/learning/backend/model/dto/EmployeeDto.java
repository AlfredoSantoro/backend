package com.alfredosantoro.learning.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private String name;
    private String surname;
    private String role;
}
