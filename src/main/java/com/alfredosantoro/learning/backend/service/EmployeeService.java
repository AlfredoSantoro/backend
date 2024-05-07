package com.alfredosantoro.learning.backend.service;

import com.alfredosantoro.learning.backend.model.dto.EmployeeDto;
import com.alfredosantoro.learning.backend.model.entity.Employee;
import com.alfredosantoro.learning.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(EmployeeDto employeeDto) {
        var employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setRole(employeeDto.getRole());
        this.employeeRepository.save(employee);
    }

    public List<EmployeeDto> findAll() {
        return this.employeeRepository.findAll()
                .stream()
                .map(entity -> EmployeeDto.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .role(entity.getRole())
                .build())
                .collect(Collectors.toList());
    }
}
