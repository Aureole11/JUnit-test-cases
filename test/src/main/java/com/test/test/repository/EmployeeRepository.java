package com.test.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.test.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
