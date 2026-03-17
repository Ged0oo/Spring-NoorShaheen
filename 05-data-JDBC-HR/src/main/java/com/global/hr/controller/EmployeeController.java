package com.global.hr.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.repo.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeRepo employeeRepo;
	
	public EmployeeController(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	@GetMapping("/count")
	public long countEmployees() {
		return employeeRepo.count();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepo.findById(id).get();
	}
	
	@GetMapping("/")
	public List<Employee> findِAllEmployees() {
		return (List<Employee>) employeeRepo.findAll();
	}
	
	@PostMapping("/new")
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
	    return employeeRepo.save(employee);
	}
	
	@GetMapping("/name/{name}")
	public List<Employee> getEmpWithNamePath(@PathVariable String name) {
	    return employeeRepo.findByName(name);
	}
	
	@GetMapping("/search")
	public List<Employee> getEmpWithNameParam(@RequestParam String name) {
	    return employeeRepo.findByName(name);
	}
}
