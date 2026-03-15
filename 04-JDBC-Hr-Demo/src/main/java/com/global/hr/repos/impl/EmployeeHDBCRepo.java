package com.global.hr.repos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repos.EmployeeRepos;


@Component
public class EmployeeHDBCRepo implements EmployeeRepos {

    @Autowired
    private JdbcTemplate jdbcTemp;
    
    @Override
    public int count() {
        return jdbcTemp.queryForObject("SELECT count(*) FROM iti.employee", Integer.class);
    }

    @Override
    public Employee findById(Long id) {
        // Correct varargs usage
        return jdbcTemp.queryForObject("SELECT * FROM iti.employee WHERE ssn = ?", new EmployeeMapper(), id);
    }
    
    @Override
    public List<Employee> findAll() {
        // Removed the WHERE clause to actually return all employees
        return jdbcTemp.query("SELECT * FROM iti.employee", new EmployeeMapper());
    }

    @Override
    public int insert(Employee emp) {
        // Removed 'new Object[]' for cleaner varargs syntax
        return jdbcTemp.update("INSERT INTO iti.employee (ssn, fname, salary) VALUES (?, ?, ?)", 
            emp.getId(), emp.getName(), emp.getSalary());
    }

    @Override
    public int update(Employee emp) {
        // Changed from INSERT to UPDATE and added WHERE clause
        return jdbcTemp.update("UPDATE iti.employee SET fname = ?, salary = ? WHERE ssn = ?", 
            emp.getName(), emp.getSalary(), emp.getId());
    }

    @Override
    public int delete(Long id) {
        // Cleaned up varargs
        return jdbcTemp.update("DELETE FROM iti.employee WHERE ssn = ?", id);
    }
}