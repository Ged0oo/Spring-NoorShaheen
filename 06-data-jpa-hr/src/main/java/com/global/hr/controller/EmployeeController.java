package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return empService.findById(id);
	}
	
	@GetMapping("")
	public List<Employee> findAllEmployees() {
		return empService.findAll();
	}
	
	@PostMapping("")
	public Employee insert(@RequestBody Employee emp) {
		return empService.insert(emp);
	}
	
	@PutMapping("")
	public Employee update(@RequestBody Employee emp) {
		return empService.update(emp);
	}
	
	@GetMapping("/department/{id}")
	public List<Employee> findByDepartmentId(@PathVariable Long id){
		return empService.findByDepartmentId(id);
	}
}
