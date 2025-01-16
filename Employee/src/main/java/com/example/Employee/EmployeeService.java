package com.example.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    // Create or update an employee
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    // Retrieve all employees
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Retrieve a specific employee by ID
    public EmployeeModel getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Delete an employee by ID
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

}
