package com.global.hr.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name = "dnum")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dname")
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
		
	public Long getId() {
		return id;
	}

	public void setDno(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(Long dno, String name) {
		super();
		this.id = dno;
		this.name = name;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
}
