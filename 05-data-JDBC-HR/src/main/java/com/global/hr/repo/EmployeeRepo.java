package com.global.hr.repo;


import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	List<Employee> findByName(String name);
}
