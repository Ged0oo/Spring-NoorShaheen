package com.global.hr.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Department;


@Repository
public interface DepartmentRepo extends CrudRepository<Department, Long>{

}
