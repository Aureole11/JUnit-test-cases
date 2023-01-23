package com.test.test.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.test.model.Employee;
import com.test.test.model.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/getAll")
	public List<Employee> getDeveloper(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Employee> getById(@PathVariable long id) {
		return service.getEmployeeById(id);
	}
	
	@PostMapping("/add")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		service.deleteEmployee(id);
	}
}
