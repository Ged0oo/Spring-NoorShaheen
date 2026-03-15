package com.global.hr.repos.impl;

import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repos.EmployeeRepos;

public class EmployeeHDBCRepoNamedParam implements EmployeeRepos {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemp;

    @Override
    public int count() {
        // queryForObject in NamedParameterJdbcTemplate requires a map even if empty
        return jdbcTemp.queryForObject("SELECT count(*) FROM iti.employee", Collections.emptyMap(), Integer.class);
    }

    @Override
    public Employee findById(Long id) {
        return jdbcTemp.queryForObject(
            "SELECT * FROM iti.employee WHERE ssn = :id", 
            new MapSqlParameterSource("id", id), 
            new EmployeeMapper()
        );
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemp.query("SELECT * FROM iti.employee", new EmployeeMapper());
    }

    @Override
    public int insert(Employee emp) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ssn", emp.getId());
        params.addValue("name", emp.getName());
        params.addValue("salary", emp.getSalary());

        return jdbcTemp.update(
            "INSERT INTO iti.employee (ssn, fname, salary) VALUES (:ssn, :name, :salary)", 
            params
        );
    }

    @Override
    public int update(Employee emp) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", emp.getName());
        params.addValue("salary", emp.getSalary());
        params.addValue("ssn", emp.getId());

        return jdbcTemp.update(
            "UPDATE iti.employee SET fname = :name, salary = :salary WHERE ssn = :ssn", 
            params
        );
    }

    @Override
    public int delete(Long id) {
        return jdbcTemp.update(
            "DELETE FROM iti.employee WHERE ssn = :ssn", 
            new MapSqlParameterSource("ssn", id)
        );
    }
}