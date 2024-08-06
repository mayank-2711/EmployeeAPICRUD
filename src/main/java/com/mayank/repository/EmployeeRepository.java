package com.mayank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
