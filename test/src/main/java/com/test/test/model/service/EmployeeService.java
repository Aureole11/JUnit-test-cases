package com.test.test.model.service;

import java.util.List;
import java.util.Optional;

import com.test.test.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
    Employee updateEmployee(Employee updatedEmployee);
    void deleteEmployee(long id);

}
