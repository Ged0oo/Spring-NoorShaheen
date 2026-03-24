package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.hr.entity.Department;
import com.global.hr.entity.Employee;
import com.global.hr.repo.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo depRepo;

	public Department findById(Long id) {
		return depRepo.findById(id).orElse(null);
	}
	
	public Department insert(Department dep) {
		return depRepo.save(dep);
	}
	
	public Department update(Department dep) {
		Department cur = depRepo.findById(dep.getId()).orElseThrow(() -> new RuntimeException("Department not found with id: " + dep.getId()));
		cur.setName(dep.getName());
		return depRepo.save(cur);
	}
	
	public List<Department> findAll(){
		return (List<Department>) depRepo.findAll();
	}
}
