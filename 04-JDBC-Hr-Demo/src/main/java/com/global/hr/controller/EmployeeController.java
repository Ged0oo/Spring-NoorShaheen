package com.global.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.repos.EmployeeRepos;
import com.global.hr.model.Employee;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepos employeeRepos;
	
	@GetMapping("/count")
	public int countEmployee() {
		return employeeRepos.count();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepos.findById(id);
	}
	
	@GetMapping("")
	public List<Employee> findById() {
		return employeeRepos.findAll();
	}
	
}
 