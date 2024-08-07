package com.mayank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee created in DataBase";
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{emp_id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long emp_id) {
		Optional<Employee> employee = employeeRepository.findById(emp_id);
		if(employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
}
