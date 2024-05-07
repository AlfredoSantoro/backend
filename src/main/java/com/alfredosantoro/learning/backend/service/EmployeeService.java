package com.alfredosantoro.learning.backend.service;

import com.alfredosantoro.learning.backend.model.dto.EmployeeDto;
import com.alfredosantoro.learning.backend.model.entity.Employee;
import com.alfredosantoro.learning.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
