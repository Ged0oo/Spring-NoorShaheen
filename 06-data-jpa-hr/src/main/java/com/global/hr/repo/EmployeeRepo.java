package com.global.hr.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{
	List<Employee> findByName(String name);

    // this is the JPQL
    @Query(value = "select emp from Employee emp where emp.name like :empName")
    List<Employee> filter(@Param("empName") String name);

    // this is the sql native
    @Query(value = "select * from hr_employees emp where emp.emp_name like :empName", nativeQuery = true)
    List<Employee> filterNative(@Param("empName") String name);


    List<Employee> findByDepartmentId(Long id);
}
