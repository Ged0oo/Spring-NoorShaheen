package com.global.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.repos.EmployeeRepos;


@Component
public class StartupProject implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRepos empRepos;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Up and Running");
	}
}
