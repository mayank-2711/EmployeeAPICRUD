package com.mayank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mayank.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value = "SELECT * FROM employee WHERE emp_city=?1", nativeQuery = true)
	List<Employee> findByEmp_city(String emp_city);
	
	@Query(value = "SELECT * FROM employee WHERE emp_age>=?1", nativeQuery = true)
    List<Employee> findByEmp_ageGreaterThanEqual(Integer emp_age);

}
