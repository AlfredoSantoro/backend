package com.alfredosantoro.learning.backend.controller;

import com.alfredosantoro.learning.backend.model.dto.EmployeeDto;
import com.alfredosantoro.learning.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody EmployeeDto employeeDto) {
        this.employeeService.save(employeeDto);
        return ResponseEntity.ok().build();
    }
}
