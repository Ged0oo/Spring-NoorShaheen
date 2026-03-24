package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.entity.Employee;
import com.global.hr.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	public Employee findById(Long id) {
		return empRepo.findById(id).orElse(null);
	}
	
	public Employee insert(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee update(Employee emp) {
		Employee cur = empRepo.findById(emp.getId()).orElseThrow(() -> new RuntimeException("Employee not found with id: " + emp.getId()));
		cur.setName(emp.getName());
		cur.setSalary(emp.getSalary());
		cur.setDepartment(emp.getDepartment());
		return empRepo.save(cur);
	}
	
	public List<Employee> findByDepartmentId(Long id){
		return empRepo.findByDepartmentId(id);
	}
	
	public List<Employee> findAll(){
		return (List<Employee>) empRepo.findAll();
	}
}
