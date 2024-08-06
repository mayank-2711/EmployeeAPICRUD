package com.mayank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.model.Employee;
import com.mayank.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")
	public String createNewEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee created in DataBase";
	}

}
