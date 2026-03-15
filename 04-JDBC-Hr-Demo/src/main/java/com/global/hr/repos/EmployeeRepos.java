package com.global.hr.repos;

import java.util.*;
import com.global.hr.model.Employee;

public interface EmployeeRepos {
	int count();
	
	Employee findById(Long id);
	
	List<Employee> findAll();
	
	int insert(Employee emp);
	
	int update(Employee emp);
	
	int delete(Long id);
}
