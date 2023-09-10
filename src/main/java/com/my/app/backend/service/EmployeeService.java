package com.my.app.backend.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.backend.models.Employee;
import com.my.app.backend.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> list() {
        return employeeRepository.findAll();
    }


}
